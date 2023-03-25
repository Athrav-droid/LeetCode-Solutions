class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                dfs(matrix, i, j, dp, matrix[i][j] - 1);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] dp, int prev){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || prev >= matrix[i][j]) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int top = dfs(matrix, i+1, j, dp, matrix[i][j]);
        int down = dfs(matrix, i-1, j, dp, matrix[i][j]);
        int right = dfs(matrix, i, j+1, dp, matrix[i][j]);
        int left = dfs(matrix, i, j-1, dp, matrix[i][j]);
        dp[i][j] = 1 + Math.max(Math.max(down, top), Math.max(right, left));
        return dp[i][j];
    }
}
