class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2) fill(grid,2,i,j);
            }
        }
        int count = 2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return -1;
                count = Math.max(count,grid[i][j]);
            }
        }
        return count-2;
    }
    public void fill(int[][] grid,int count,int row, int col){
        if(row < 0 || col < 0 /* out of bounds */
        || row >= grid.length || col >= grid[0].length /* out of bounds */
        || grid[row][col] == 0 /* empty cell */
        || (1 < grid[row][col] && grid[row][col] < count)) /* this orange is already rotten by another rotten orange */
        return;
        else{
            grid[row][col] = count;
            fill(grid,count+1,row+1,col);
            fill(grid,count+1,row,col+1);
            fill(grid,count+1,row-1,col);
            fill(grid,count+1,row,col-1);
        }
    }
}