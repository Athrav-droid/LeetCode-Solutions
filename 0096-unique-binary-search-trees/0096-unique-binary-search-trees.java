    class Solution {
        // Catalan Number
    public int numTrees(int n) {
        // return helper(n);

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return helperMem(n, dp);

        return helperTab(n);
    }

    // Recrusive Method
    public int helper(int n){
        if(n <= 1) return 1;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += helper(i - 1) * helper(n - i);
        }
        return ans;
    }

    // Memoization Method
    public int helperMem(int n, int[] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += helperMem(i - 1, dp) * helperMem(n - i, dp);
        }
        return dp[n] = ans;
    }

    // Tabulation Method
    public int helperTab(int n){
        int[] dp = new int[n + 1];
        // Base Case
        dp[0] = dp[1] = 1;

        // Number of Nodes:- since 0, 1 are handeled in base case so we have remaining 2 to n
        for(int i = 2; i <= n; i++){
            // Number of Roots or Roots Value, j <= i because i is no. of nodes and practically roots can be till number of nodes
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}