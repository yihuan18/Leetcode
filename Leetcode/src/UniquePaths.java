/*
Leetcode Q62 : 不同路径
一个机器人位于一个 m x n 网格的左上角
（起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。
机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        int[][] paths = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0)
                    paths[i][j] = 1;
                else paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(51,9));
    }
}
