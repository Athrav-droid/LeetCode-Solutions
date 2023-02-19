class Solution {
    // https://leetcode.com/problems/perfect-squares/solutions/2837992/java-recursion-memoization-dp-3-square-theorem-explained/?languageTags=java
    public int numSquares(int n) {
        // int[] mem = new int[n+1];
        // Arrays.fill(mem, -1);
        // return memoization(n, mem);

        return tabulation(n);
    }
    // public int bruteForce(int n){ //TLE
    //     if(n < 4) return n;
    //     int ans = n;
    //     for(int i = 1; i * i<=n; i++){
    //         ans = Math.min(ans, 1 + bruteForce(n - i * i));
    //     }
    //     return ans;
    // }

    // public int memoization(int n, int[] mem){
    //     if(n == 0) return 0;
    //     if(mem[n] != -1) return mem[n];
    //     int ans = n;
    //     for(int i = 1; i * i<=n; i++){
    //         ans = Math.min(ans, 1 + memoization(n - i * i, mem));
    //     }
    //     return mem[n] = ans;
    // }

    public int tabulation(int n){ //done using memoization code
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=n;j++){
                if((i - j * j) >= 0) dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }
        return dp[n];
    }
}