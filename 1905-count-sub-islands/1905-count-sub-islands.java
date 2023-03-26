class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1) dfs(grid2, i, j);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    ans++;
                    dfs(grid2, i, j);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid2,int i,int j){
        if(i<0 || j<0 || i>=grid2.length|| j>=grid2[0].length || grid2[i][j]==0) return;
        grid2[i][j]=0; 
        dfs(grid2, i - 1, j);
        dfs(grid2, i + 1, j);
        dfs(grid2, i, j - 1);
        dfs(grid2, i, j + 1);
    }
}