import java.util.HashSet;
import java.util.Set;
//判断数独是否有效 行列以及小块都不重复
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> charSet = new HashSet<>();
        //validate rows
        for(int row = 0 ; row < board.length ; row++){
            charSet.clear();
            for(int col = 0 ; col < board[0].length ; col++){
                if(board[row][col] == '.')
                    continue;
                if(charSet.contains(board[row][col]))
                    return false;
                else
                    charSet.add(board[row][col]);
            }
        }
        //validate columns
        for(int col = 0 ; col < board[0].length ; col++){
            charSet.clear();
            for(int row = 0 ; row < board.length ; row++){
                if(board[row][col] == '.')
                    continue;
                if(charSet.contains(board[row][col]))
                    return false;
                else
                    charSet.add(board[row][col]);
            }
        }
        //validate small blocks
        for(int i = 0 ; i < 9 ; i+=3){ //every block
            for(int j = 0 ; j < 9 ; j+=3){
                charSet.clear();
                for(int row = i ; row < i+3 ; row++)
                    for(int col = j ; col < j + 3 ; col++){
                        if(board[row][col] == '.')
                            continue;
                        if(charSet.contains(board[row][col]))
                            return false;
                        else
                            charSet.add(board[row][col]);
                    }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidSudoku validSudoku = new ValidSudoku();
        char input[][] = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        boolean ret = validSudoku.isValidSudoku(input);
        System.out.print(ret);
    }
}
