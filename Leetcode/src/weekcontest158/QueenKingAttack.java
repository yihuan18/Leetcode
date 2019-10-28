package weekcontest158;

import java.util.ArrayList;
import java.util.List;

public class QueenKingAttack {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        //convert queens sites to map
        int[][] checker = new int[8][8];
        List<List<Integer>> ret = new ArrayList<>();

        for(int i = 0 ; i < queens.length ; i++){
            checker[queens[i][0]][queens[i][1]] = 1;
        }

        int row = king[0];
        int col = king[1];
        //searchLeft
        for(int j = col - 1 ; j >= 0 ; j--){
            if(checker[row][j] == 1){
                addResult(row,j,ret);
                break;
            }
        }

        //searchRight
        for(int j = col + 1 ; j < 8 ; j++){
            if(checker[row][j] == 1){
                addResult(row,j,ret);
                break;
            }
        }

        //searchUp
        for(int i = row - 1 ; i >= 0 ; i--){
            if(checker[i][col] == 1){
                addResult(i,col,ret);
                break;
            }
        }

        //searchDown
        for(int i = row + 1; i < 8 ; i++){
            if(checker[i][col] == 1){
                addResult(i,col,ret);
                break;
            }
        }

        //search upleft
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0){
            if(checker[i][j] == 1){
                addResult(i,j,ret);
                break;
            }
            i = i - 1;
            j = j - 1;
        }

        //search upright
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < 8){
            if(checker[i][j] == 1){
                addResult(i,j,ret);
                break;
            }
            i = i - 1;
            j = j + 1;
        }

        //search down left
        i = row + 1;
        j = col - 1;
        while (i < 8 && j >= 0){
            if(checker[i][j] == 1){
                addResult(i,j,ret);
                break;
            }
            i = i + 1;
            j = j - 1;
        }

        //search down right
        i = row + 1;
        j = col + 1;
        while (i < 8 && j < 8){
            if(checker[i][j] == 1){
                addResult(i,j,ret);
                break;
            }
            i = i + 1;
            j = j + 1;
        }

        return ret;
    }

    private void addResult(int i , int j, List<List<Integer>> ret){
        List<Integer> location = new ArrayList<>();
        location.add(i);
        location.add(j);
        ret.add(location);
    }

    public static void main(String[] args) {
        QueenKingAttack queenKingAttack = new QueenKingAttack();
        int[][] queen = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = {3,3};
        System.out.println(queenKingAttack.queensAttacktheKing(queen,king));
    }
}
