class Solution {
    public int maxProfit(int[] prices) {
        // return helper(prices, 0, 1, 2);

        int[][][] dp = new int[prices.length + 1][2][3];
        for(int[][] row : dp) for(int[] col : row) Arrays.fill(col, -1);
        return helperMem(prices, 0, 1, 2, dp);

        // return helperTab(prices);

        // return helperSO(prices);
    }

    public int helper(int[] prices, int index, int buy, int limit){
        // Base Case
        if(index == prices.length) return 0;
        if(limit == 0) return 0;

        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helper(prices, index + 1, 0, limit);
            int skipKaro = helper(prices, index + 1, 1, limit);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helper(prices, index + 1, 1, limit - 1);
            int skipKaro = helper(prices, index + 1, 0, limit);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return totalProfit;
    }

    public int helperMem(int[] prices, int index, int buy, int limit, int[][][] dp){
        // Base Case
        if(index == prices.length) return 0;
        if(limit == 0) return 0;

        if(dp[index][buy][limit] != -1) return dp[index][buy][limit];
        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helperMem(prices, index + 1, 0, limit, dp);
            int skipKaro = helperMem(prices, index + 1, 1, limit, dp);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helperMem(prices, index + 1, 1, limit - 1, dp);
            int skipKaro = helperMem(prices, index + 1, 0, limit, dp);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return dp[index][buy][limit] = totalProfit;
    }

    public int helperTab(int[] prices){
        int[][][] dp = new int[prices.length + 1][2][3];
        for(int[][] row : dp) for(int[] col : row) Arrays.fill(col, 0);

        for(int index = prices.length - 1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                for(int limit = 1; limit < 3; limit++){
                    int totalProfit = 0;
                    if(buy == 1){
                        int buyKaro = -prices[index] + dp[index + 1][0][limit];
                        int skipKaro = dp[index + 1][1][limit];
                        totalProfit = Math.max(buyKaro, skipKaro);
                    }else{
                        int sellKaro = prices[index] + dp[index + 1][1][limit - 1];
                        int skipKaro = dp[index + 1][0][limit];
                        totalProfit = Math.max(sellKaro, skipKaro);
                    }
                    dp[index][buy][limit] = totalProfit;
                }
            }
        }
        return dp[0][1][2];
    }

    public int helperSO(int[] prices){
        int[][] curr = new int[2][3];
        int[][] next = new int[2][3];
        for(int[] row : curr) Arrays.fill(row, 0);
        for(int[] row : next) Arrays.fill(row, 0);

        for(int index = prices.length - 1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                for(int limit = 1; limit < 3; limit++){
                    int totalProfit = 0;
                    if(buy == 1){
                        int buyKaro = -prices[index] + next[0][limit];
                        int skipKaro = next[1][limit];
                        totalProfit = Math.max(buyKaro, skipKaro);
                    }else{
                        int sellKaro = prices[index] + next[1][limit - 1];
                        int skipKaro = next[0][limit];
                        totalProfit = Math.max(sellKaro, skipKaro);
                    }
                    curr[buy][limit] = totalProfit;
                }
            }
            next = curr.clone();
        }
        return next[1][2];
    }
}