class Solution {
    int mod = 1000000007;
    int[][][] dp = new int[101][101][101];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for(int i = 0; i <= group.length; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 0, 0, n, minProfit, group, profit);
    }
    public int helper(int index, int count, int profit, int n, int minProfit, int[] group, int[] profits){
        // if index equals length of group given means we are at last index, so return 1 when we obtained profit else zero
        if(index == group.length) return profit >= minProfit ? 1 : 0;
        // memoization check
        if(dp[index][count][profit] != -1) return dp[index][count][profit];
        // when we are not including the current crime, so just moving to the next crime that's why increasing index
        int ans = helper(index + 1, count, profit, n, minProfit, group, profits);
        // if adding group[index] members in current members still remain in range then increase index, add members and add the profit. Using Math.min because we don't want to go out of boundation.
        if(count + group[index] <= n){
            ans += helper(index + 1, count + group[index], Math.min(minProfit ,profit + profits[index]), n, minProfit, group, profits);
        }
        // since values can be large so doing mod.
        return dp[index][count][profit] = ans % mod;
    }
}