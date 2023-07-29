class Solution {
    public double soupServings(int n) {
        if(n >= 5000) return 1.00000;
        double[][] dp = new double[n+1][n+1];
        for(double[] row : dp) Arrays.fill(row, -1.0);
        return  helper(n, n, dp);
    }

    int[][] servings = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};

    public double helper(int a, int b, double[][] dp){
        double ans = 0.0;
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0;
        if(dp[a][b] != -1) return dp[a][b];
        for(int i = 0; i < servings.length; i++){
            ans = ans + helper(a - servings[i][0], b - servings[i][1], dp);
        }
        return dp[a][b] = (0.25 * ans);
    }

}