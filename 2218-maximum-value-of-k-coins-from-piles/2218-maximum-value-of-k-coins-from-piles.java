class Solution {
    int[][] dp = new int[1001][2001];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for(int i = 0; i < piles.size(); i++)
            for(int j = 1; j < piles.get(i).size(); j++)
                piles.get(i).set(j, piles.get(i).get(j) + piles.get(i).get(j - 1));

        for(int i = 0; i <= piles.size(); i++)
            for(int j = 0; j <= k; j++)
                dp[i][j] = -1;
        
        return helper(piles, k, 0);
    }
    public int helper(List<List<Integer>> piles, int k, int i){
        if(i >= piles.size()) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int max = 0;
        max = Math.max(max, helper(piles, k, i + 1));
        for(int j = 0; j < piles.get(i).size(); j++){
            if(j + 1 <= k) max = Math.max(max, piles.get(i).get(j) + helper(piles, k - j - 1, i + 1));
            else break;
        }
        return dp[i][k] = max;
    }
}