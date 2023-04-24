class Solution {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        // helper(matrix, 0, 0);

        // int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        // for(int[] a : dp) Arrays.fill(a, -1);
        // helperMem(matrix, 0, 0, dp);

        helperTab(matrix);

        return max * max;
    }

    // public int helper(char[][] matrix, int i, int j){
    //     if(i >= matrix.length || j >= matrix[0].length) return 0;
    //     int right = helper(matrix, i, j + 1);
    //     int diagonal = helper(matrix, i + 1, j + 1);
    //     int bottom = helper(matrix, i + 1, j);
    //     int ans = 0;
    //     if(matrix[i][j] == '1'){
    //         ans = 1 + Math.min(right, Math.min(diagonal, bottom));
    //         max = Math.max(max, ans);
    //     }
    //     else return 0;
    //     return ans;
    // }

    // public int helperMem(char[][] matrix, int i, int j, int[][] dp){
    //     if(i >= matrix.length || j >= matrix[0].length) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int right = helperMem(matrix, i, j + 1, dp);
    //     int diagonal = helperMem(matrix, i + 1, j + 1, dp);
    //     int bottom = helperMem(matrix, i + 1, j, dp);
    //     int ans = 0;
    //     if(matrix[i][j] == '1'){
    //         ans = 1 + Math.min(right, Math.min(diagonal, bottom));
    //         max = Math.max(max, ans);
    //     }
    //     else return dp[i][j] = 0;
    //     return dp[i][j] = ans;
    // }

    public int helperTab(char[][] matrix){
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int row[] : dp) Arrays.fill(row, 0);
        for(int row = matrix.length - 1; row >= 0; row--){
            for(int col = matrix[0].length - 1; col >= 0; col--){
                int right = dp[row][col + 1];
                int diagonal = dp[row + 1][col + 1];
                int bottom = dp[row + 1][col];
                if(matrix[row][col] == '1'){
                    dp[row][col] = 1 + Math.min(right, Math.min(diagonal, bottom));
                    max = Math.max(max, dp[row][col]);
                }
                else dp[row][col] = 0;
            }
        }
        return dp[0][0];
    }
}