/*
LeetCode Q73 : 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
请使用原地算法。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zerosIndex = new ArrayList<>();
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                //if current num equals 0 , set elements before it to 0
                if(matrix[i][j] == 0) {
                    zerosIndex.add(Arrays.asList(i, j));
                    for(int temp = 0 ; temp < i ; temp++)
                        matrix[temp][j] = 0;
                    for(int temp = 0 ; temp < j ; temp++)
                        matrix[i][temp] = 0;
                    continue;
                }
                //if current num is not 0 , judge if it should be transferred to 0
                if(zerosIndex.size() != 0){
                    for(List<Integer> index : zerosIndex){
                        if(i == index.get(0) || j == index.get(1)){
                            matrix[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    /*
    用首行和首列标记某行某列是否需要置0，首行和首例是否需要置0使用额外两个变量表示

    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        boolean firstRow_0 = false, firstCol_0 = false;

        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                if(i != 0 && j!=0 && matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }else if(matrix[i][j] == 0){
                    firstRow_0 = i==0?true:firstRow_0;
                    firstCol_0 = j==0?true:firstCol_0;
                }
            }
        for(int i=1;i<matrix.length;i++)
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        if(firstCol_0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow_0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
    }
     */

    public static void main(String args[]){
        SetZeroes sz = new SetZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        sz.setZeroes(matrix);
        for(int[] temp : matrix){
            for(int i : temp)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
