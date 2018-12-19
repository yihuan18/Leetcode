/*
LeetCode Q200 : 岛屿的个数
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
你可以假设网格的四个边均被水包围。
 */
public class NumIslands {
    //可以使用原地算法，将'1'改为'2'表示已经访问过
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int ret = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    traverseGrid(grid, visited, i, j);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void traverseGrid(char[][] grid , boolean visited[][], int i , int j){
        visited[i][j] = true;
        //left
        if((j - 1) >= 0 && grid[i][j-1] == '1' && !visited[i][j-1])
            traverseGrid(grid,visited,i,j-1);
        //right
        if((j + 1) < grid[0].length && grid[i][j+1] == '1' && !visited[i][j+1])
            traverseGrid(grid,visited,i,j+1);
        //top
        if((i - 1) >= 0 && grid[i-1][j] == '1' && !visited[i-1][j])
            traverseGrid(grid,visited,i-1,j);
        //bottom
        if((i + 1) < grid.length && grid[i+1][j] == '1' && !visited[i+1][j])
            traverseGrid(grid,visited,i+1,j);
    }
}
