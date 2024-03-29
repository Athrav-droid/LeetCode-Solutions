class Solution {
    // Can also be solved using Recrusive, Memoization, Tabulation and Space Optimization method.
    // We have to just apply that we have to buy or not and also sell or not, include exclude logic
    // also when we buy -ve price will be added, and when sell +ve price will be added.

    public int maxProfit(int[] prices) {
        // ONE PASS METHOD
        // return onePassMethod(prices);
        
        // Recursion Method
        // return helper(prices, 0, 1);

        // Memoization Method
        // int[][] dp = new int[prices.length + 1][2];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return helperMem(prices, 0, 1, dp);

        // Tabulation Method
        // return helperTab(prices);
        
        // Space Optimization Method
        return helperSO(prices);
    }

    public int onePassMethod(int[] prices){
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
         return maxProfit;
    }

    public int helper(int[] prices, int index, int buy){
        // Base Case
        if(index == prices.length) return 0;
        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helper(prices, index + 1, 0);
            int skipKaro = helper(prices, index + 1, 1);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helper(prices, index + 1, 1);
            int skipKaro = helper(prices, index + 1, 0);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return totalProfit;
    }

    public int helperMem(int[] prices, int index, int buy, int[][] dp){
        // Base Case
        if(index == prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helperMem(prices, index + 1, 0, dp);
            int skipKaro = helperMem(prices, index + 1, 1, dp);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helperMem(prices, index + 1, 1, dp);
            int skipKaro = helperMem(prices, index + 1, 0, dp);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return dp[index][buy] = totalProfit;
    }

    public int helperTab(int[] prices){
        int[][] dp = new int[prices.length + 1][2];
        for(int[] row : dp) Arrays.fill(row, 0);

        for(int index = prices.length - 1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                int totalProfit = 0;
                if(buy == 1){
                    int buyKaro = -prices[index] + dp[index + 1][0];
                    int skipKaro = dp[index + 1][1];
                    totalProfit = Math.max(buyKaro, skipKaro);
                }else{
                    int sellKaro = prices[index] + dp[index + 1][1];
                    int skipKaro = dp[index + 1][0];
                    totalProfit = Math.max(sellKaro, skipKaro);
                }
                dp[index][buy] = totalProfit;
            }
        }
        return dp[0][1];
    }

    public int helperSO(int[] prices){
        int[] curr = new int[2];
        int[] next = new int[2];
        Arrays.fill(curr, 0);
        Arrays.fill(next, 0);

        for(int index = prices.length - 1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                int totalProfit = 0;
                if(buy == 1){
                    int buyKaro = -prices[index] + next[0];
                    int skipKaro = next[1];
                    totalProfit = Math.max(buyKaro, skipKaro);
                }else{
                    int sellKaro = prices[index] + next[1];
                    int skipKaro = next[0];
                    totalProfit = Math.max(sellKaro, skipKaro);
                }
                curr[buy] = totalProfit;
            }
            next = curr.clone();
        }
        return next[1];
    }
}