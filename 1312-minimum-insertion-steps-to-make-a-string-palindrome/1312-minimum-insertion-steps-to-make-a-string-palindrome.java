class Solution {
    // Keeping the longest palindromic subsequence common and rest elements will be add to the string resulting in the min number of operations.
    public int minInsertions(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        // length of given string - longest palindromic string length will be the answer
        return s.length() - helperTab(s, sb.toString());
    }
    public int helperTab(String t1, String t2){
        int[][] dp = new int [t1.length() + 1][t2.length() + 1];
        for(int[] row : dp) Arrays.fill(row, 0);

        for(int i = t1.length() - 1; i >= 0; i--){
            for(int j = t2.length() - 1; j >= 0; j--){
                int ans = 0;
                if(t1.charAt(i) == t2.charAt(j)) ans = 1 + dp[i+1][j+1];
                else ans = Math.max(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}