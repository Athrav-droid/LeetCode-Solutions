class Solution {
    public int numEnclaves(int[][] grid) { 
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][n - 1] == 1) dfs(grid, i, n - 1);
        }
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1) dfs(grid, 0, i);
            if(grid[m - 1][i] == 1) dfs(grid, m - 1, i); 
        }
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n - 1; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return;
        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}