class Solution {
    public int trailingZeroes(int n) {
        return n/3125 + n/625 + n/125 + n/25 + n/5;
        // if(n == 0) return 0;
        // long[] dp = new long[n+1];
        // Arrays.fill(dp, -1);
        // long a = fact(n,dp);
        // System.out.println(a);
        // int count = 0;
        // while((a % 10 ) == 0){
        //     count++;
        //     a/=10;
        // }
        // return count;
    }
    public long fact(int n, long[] dp){
        if(n==1 || n==2) return n;
        dp[0] = 1;
        dp[1] = 2;
        if(dp[n] != -1) return dp[n];
        dp[n] = n * fact(n-1,dp);
        return dp[n];
    }
}