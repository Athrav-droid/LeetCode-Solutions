class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        int takeOne = Integer.MIN_VALUE, takeTwo = Integer.MIN_VALUE, takeThree = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            takeOne = stoneValue[i] - dp[i + 1];
            if(i + 1 < n)
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            if(i + 2 < n)
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            dp[i] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        }
        if(dp[0] > 0) return "Alice";
        else if(dp[0] < 0) return "Bob";
        else return "Tie";
    }
}