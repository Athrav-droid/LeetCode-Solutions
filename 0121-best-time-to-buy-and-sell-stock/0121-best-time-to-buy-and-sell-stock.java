class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;
        for(int price : prices){
            minimum = Math.min(minimum,price); // it will lock the minimum price. 
            maxProfit = Math.max(maxProfit,price-minimum); //it will lock the maximum profit.
        }
        return maxProfit;
    }
}