class Solution {
    boolean ans = false;
    public boolean checkValidGrid(int[][] grid) {
        dfs(grid, 0, 0, -1);
        return ans;
    }
    public void dfs(int[][] grid, int row, int col, int curr){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid.length || grid[row][col] != curr + 1) return;
        if(grid[row][col] == grid.length * grid.length - 1) ans = true;
        dfs(grid, row - 2, col - 1, grid[row][col]);
        dfs(grid, row - 2, col + 1, grid[row][col]);
        dfs(grid, row + 2, col - 1, grid[row][col]);
        dfs(grid, row + 2, col + 1, grid[row][col]);
        dfs(grid, row - 1, col + 2, grid[row][col]);
        dfs(grid, row - 1, col - 2, grid[row][col]);
        dfs(grid, row + 1, col + 2, grid[row][col]);
        dfs(grid, row + 1, col - 2, grid[row][col]);
    }
    
}
