/*
Leetcode Q240 : 搜索二维矩阵II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while(rows!=0 && columns!=0){
            int tmp = matrix[rows-1][matrix[0].length-columns];
            if(tmp == target)
                return true;
            if(tmp < target)
                columns--;
            else rows--;

        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean ret = sm.searchMatrix(matrix,20);
        System.out.println(ret);
    }
}
