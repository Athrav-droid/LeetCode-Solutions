class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        // return helperRec(n, k, target);

        int[][] dp = new int[n + 1][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(n, k, target, dp);

        // return helperTab(n, k, target);

        // return helperSO(n, k, target);
    }

    //RECURSION APPROACH
    // n = no. of dice, k = no. of faces
    public int helperRec(int n, int k, int target){
        if(target < 0) return 0;
        if(n == 0 && target != 0) return 0;
        if(n != 0 && target == 0) return 0;
        if(n == 0 && target == 0) return 1;
        int ans = 0;
        for(int i = 1; i <= k; i++){
            ans = (ans + helperRec(n - 1, k, target - i)) % mod;
        }
        return ans % mod;
    }

    //MEMOIZATION CALL
    public int helperMem(int n, int k, int target, int[][] dp){
        if(target < 0) return 0;
        if(n == 0 && target != 0) return 0;
        if(n != 0 && target == 0) return 0;
        if(n == 0 && target == 0) return 1;
        if(dp[n][target] != -1) return dp[n][target];
        int ans = 0;
        for(int i = 1; i <= k; i++){
            ans = (ans + helperMem(n - 1, k, target - i, dp)) % mod;
        }
        return dp[n][target] = (ans % mod);
    }

    //TABULATION CALL
    public int helperTab(int d, int f, int tar){
        int[][] dp = new int[d + 1][tar + 1];

        dp[0][0] = 1;

        for(int n = 1; n <= d; n++){
            for(int target = 1; target <= tar; target++){
                int ans = 0;
                for(int i = 1; i <= f; i++){
                    if(target - i >= 0) ans = (ans + dp[n - 1][target - i]) % mod;
                }
                dp[n][target] = (ans % mod);
            }
        }
        return dp[d][tar];
    }

    //SPACE OPTIMIZATION APPROACH
    public int helperSO(int d, int f, int tar){
        int[] curr = new int[tar + 1];
        int[] prev = new int[tar + 1];

        prev[0] = 1;

        for(int n = 1; n <= d; n++){
            for(int target = 1; target <= tar; target++){
                int ans = 0;
                for(int i = 1; i <= f; i++){
                    if(target - i >= 0) ans = (ans + prev[target - i]) % mod;
                }
                curr[target] = (ans % mod);
            }
            prev = curr.clone();
        }
        return curr[tar];
    }
}