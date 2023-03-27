class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        // int[][] dp = new int[m][n];
        // dfs(0, 0, grid, 0, dp);
        // return min;
        for(int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for(int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
    // public void dfs(int row, int col, int[][] grid, int sum, int[][] dp){
    //     if(row >= grid.length || col >= grid[0].length) return;
    //     sum += grid[row][col];
    //     if(row == grid.length - 1 && col == grid[0].length - 1) min = Math.min(min, sum);
    //     dfs(row + 1, col, grid, sum, dp);
    //     dfs(row, col + 1, grid, sum, dp);
    // }
}