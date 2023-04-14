class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return helper(text1, text2, 0, 0);

        // int a = text1.length();
        // int b = text2.length();
        // int[][] dp = new int[a][b];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return helperMem(text1, text2, 0, 0, dp);

        return helperTab(text1, text2);

        // return helperSpace(text1, text2);
    }
    // public int helper(String t1, String t2, int i, int j){
    //     if(i == t1.length()) return 0;
    //     if(j == t2.length()) return 0;
    //     if(t1.charAt(i) == t2.charAt(j)) return 1 + helper(t1, t2, i+1, j+1);
    //     else return Math.max(helper(t1, t2, i+1, j), helper(t1, t2,i, j+1));
    // }

    // public int helperMem(String t1, String t2, int i, int j, int[][] dp){
    //     if(i == t1.length()) return 0;
    //     if(j == t2.length()) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int ans = 0;
    //     if(t1.charAt(i) == t2.charAt(j)) ans = 1 + helperMem(t1, t2, i+1, j+1, dp);
    //     else ans = Math.max(helperMem(t1, t2, i+1, j, dp), helperMem(t1, t2,i, j+1, dp));
    //     return dp[i][j] = ans;
    // }

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

    // public int helperSpace(String t1, String t2){
    //     int[] curr = new int[t2.length() + 1];
    //     int[] next = new int[t2.length() + 1];
    //     Arrays.fill(curr, 0);
    //     Arrays.fill(next, 0);

    //     for(int i = t1.length() - 1; i >= 0; i--){
    //         for(int j = t2.length() - 1; j >= 0; j--){  
    //             int ans = 0;
    //             if(t1.charAt(i) == t2.charAt(j)) ans = 1 + next[j+1];
    //             else ans = Math.max(next[j], curr[j+1]);
    //             curr[j] = ans;
    //         }
    //         next = curr;
    //     }
    //     return next[0];
    // }
}