class Solution{
    public int ways(String[] pizza, int k){
        int m = pizza.length;
        int n = pizza[0].length();
        Integer[][][] dp = new Integer[k][m][n];
        int[][] preSum = new int[m + 1][n + 1];
        for(int r = m - 1; r >= 0; r--)
            for(int c = n - 1; c >= 0; c--)
                preSum[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0) + preSum[r + 1][c] + preSum[r][c + 1] - preSum[r + 1][c + 1];
        
        return dfs(m, n, k-1, 0, 0, dp, preSum);
    }
    public int dfs(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] preSum){
        if(preSum[r][c] == 0) return 0;
        if(k == 0) return 1;
        if(dp[k][r][c] != null) return dp[k][r][c];
        int ans = 0;
        for(int nr = r + 1; nr < m; nr++){
            if(preSum[r][c] - preSum[nr][c] > 0)
                ans = (ans + dfs(m, n, k - 1, nr, c, dp, preSum)) % 1_000_000_007;
        }
        for(int nc = c + 1; nc < n; nc++){
            if(preSum[r][c] - preSum[r][nc] > 0)
                ans = (ans + dfs(m, n, k - 1, r, nc, dp, preSum)) % 1_000_000_007;
        }
        return dp[k][r][c] = ans;
    }
}


// class Solution {
//     public int ways(String[] pizza, int k) {
//         int rows = pizza.length, cols = pizza[0].length();
//         int apples[][] = new int[rows + 1][cols + 1];
//         int dp[][][] = new int[k][rows][cols];
//         for (int row = rows - 1; row >= 0; row--) {
//             for (int col = cols - 1; col >= 0; col--) {
//                 apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1]
//                         - apples[row + 1][col + 1];
//                 dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
//             }
//         }
//         int mod = 1000000007;
//         for (int remain = 1; remain < k; remain++) {
//             for (int row = 0; row < rows; row++) {
//                 for (int col = 0; col < cols; col++) {
//                     for (int next_row = row + 1; next_row < rows; next_row++) {
//                         if (apples[row][col] - apples[next_row][col] > 0) {
//                             dp[remain][row][col] += dp[remain - 1][next_row][col];
//                             dp[remain][row][col] %= mod;
//                         }
//                     }
//                     for (int next_col = col + 1; next_col < cols; next_col++) {
//                         if (apples[row][col] - apples[row][next_col] > 0) {
//                             dp[remain][row][col] += dp[remain - 1][row][next_col];
//                             dp[remain][row][col] %= mod;
//                         }
//                     }
//                 }
//             }
//         }
//         return dp[k - 1][0][0];
//     }
// }