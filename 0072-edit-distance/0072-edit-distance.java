class Solution {
    public int minDistance(String word1, String word2) {
        // return minDistanceRecursive(word1, word2, word1.length(), word2.length());

        // int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        // for(int[] row : memo){
        //     Arrays.fill(row, -1);
        // }
        // return minDistanceMemo(word1, word2, word1.length(), word2.length(), memo);

        return minDistanceTab(word1, word2, word1.length(), word2.length());
    }
    public int minDistanceTab(String word1, String word2, int w1Index, int w2Index){
        int w1 = word1.length();
        int w2 = word2.length();
        if(w1 == 0) return w2;
        if(w2 == 0) return w1;
        int[][] dp = new int[w1+1][w2+1];
        for(int i = 1; i <= w1; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= w2; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= w1; i++){
            for(int j = 1; j <= w2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[w1][w2];
    }
    public int minDistanceRecursive(String word1, String word2, int w1Index, int w2Index){
        if(w1Index == 0) return w2Index;
        if(w2Index == 0) return w1Index;
        if(word1.charAt(w1Index-1) == word2.charAt(w2Index-1))
            return minDistanceRecursive(word1, word2, w1Index-1, w2Index-1);
        else{
            int insert = minDistanceRecursive(word1, word2, w1Index, w2Index-1);
            int delete = minDistanceRecursive(word1, word2, w1Index-1, w2Index);
            int replace = minDistanceRecursive(word1, word2, w1Index-1, w2Index-1);
            return Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }
    public int minDistanceMemo(String word1, String word2, int w1Index, int w2Index, int[][] memo){
        if(w1Index == 0) return w2Index;
        if(w2Index == 0) return w1Index;
        if(memo[w1Index][w2Index] != -1){
            return memo[w1Index][w2Index];
        }
        if(word1.charAt(w1Index-1) == word2.charAt(w2Index-1))
            return memo[w1Index][w2Index] = minDistanceRecursive(word1, word2, w1Index-1, w2Index-1);
        else{
            int insert = minDistanceRecursive(word1, word2, w1Index, w2Index-1);
            int delete = minDistanceRecursive(word1, word2, w1Index-1, w2Index);
            int replace = minDistanceRecursive(word1, word2, w1Index-1, w2Index-1);
            return memo[w1Index][w2Index] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }
}