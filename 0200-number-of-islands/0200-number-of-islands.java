class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    findArea(grid,i,j);
                }
            }
        }    
        return count;
    }
    public void findArea(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') return;
        grid[row][col] = '0';
        findArea(grid,row+1,col);
        findArea(grid,row,col+1);
        findArea(grid,row-1,col);
        findArea(grid,row,col-1);
    }
}