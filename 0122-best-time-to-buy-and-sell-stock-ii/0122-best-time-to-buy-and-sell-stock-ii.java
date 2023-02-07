class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;

        // int maxProfit = 0, i = 0;
        // int peak = prices[0], valley = prices[0];
        // while(i < prices.length - 1){
        //     while(i < prices.length-1 && prices[i] >= prices[i+1]) i++;
        //     valley = prices[i];
        //     while(i < prices.length-1 && prices[i] <= prices[i+1]) i++;
        //     peak = prices[i];
        //     maxProfit += peak - valley;
        // }
        // return maxProfit;
    }
}