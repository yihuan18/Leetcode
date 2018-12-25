/*
Leetcode Q79 : 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。
 */
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0)) {
                    board[i][j] = '.';
                    if (searchAround(board, word, i, j, 1))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    private boolean searchAround(char[][] board , String word , int i , int j , int level){
        if(level == word.length())
            return true;
        char c = word.charAt(level);
        //search up
        if(i > 0 && c == board[i-1][j]) {
            board[i-1][j] = '.';
            if (searchAround(board, word, i - 1, j, level + 1))
                return true;
            board[i-1][j] = c;
        }
        //search down
        if(i < (board.length - 1) && c == board[i+1][j]) {
            board[i+1][j] = '.';
            if (searchAround(board, word, i + 1, j, level + 1))
                return true;
            board[i+1][j] = c;
        }
        //search left
        if(j > 0 && c == board[i][j-1]) {
            board[i][j-1] = '.';
            if (searchAround(board, word, i, j-1, level + 1))
                return true;
            board[i][j-1] = c;
        }
        //search right
        if(j < (board[0].length - 1) && c == board[i][j+1]) {
            board[i][j+1] = '.';
            if (searchAround(board, word, i, j+1, level + 1))
                return true;
            board[i][j+1] = c;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'a','b'}};
        boolean ret = wordSearch.exist(board , "ba");
        System.out.print(ret);
    }
}
