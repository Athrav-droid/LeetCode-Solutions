class Solution { 
    int[][] dir = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        // return helper(n, k, row, column);

        double[][][] dp = new double[k + 1][n + 1][n + 1];
        for(double[][] outer : dp) for(double[] r : outer) Arrays.fill(r, -1);
        return helperMem(n, k, row, column, dp);
    }

    public double helper(int n, int k, int row, int column){
        if(row < 0 || column < 0 || row >= n || column >= n) return 0;
        if(k == 0) return 1;
        double result = 0;
        for(int i = 0; i < 8; i++){
            result += helper(n, k - 1, row + dir[i][0], column + dir[i][1]);
        }
        return (double) result / 8; 
    }

    public double helperMem(int n, int k, int row, int column, double[][][] dp){
        if(row < 0 || column < 0 || row >= n || column >= n) return 0;
        if(k == 0) return 1;
        if(dp[k][row][column] != -1) return dp[k][row][column];
        double result = 0;
        for(int i = 0; i < 8; i++){
            result += helperMem(n, k - 1, row + dir[i][0], column + dir[i][1], dp);
        }
        return dp[k][row][column] = (double) result / 8; 
    }
}