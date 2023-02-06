class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,findArea(grid,i,j));
                }
            }
        }    
        return maxArea;
    }
    public int findArea(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) return 0;
        grid[row][col] = 0;
        return 1 + findArea(grid,row+1,col) + findArea(grid,row,col+1) + findArea(grid,row-1,col) + findArea(grid,row,col-1);
    }
    // public void findArea(int[][] grid, int area, int row, int col){
    //     if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) return;
    //     area++;
    //     grid[row][col] = 0;
    //     findArea(grid,area,row+1,col);
    //     findArea(grid,area,row,col+1);
    //     findArea(grid,area,row,col-1);
    //     findArea(grid,area,row-1,col);
    // }
}