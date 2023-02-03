class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //0th column every row initialize with 1
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        //0th row every column initialize with 1
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        //filling remaining rows of dp table and the last block where we have to reach is our answer
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}