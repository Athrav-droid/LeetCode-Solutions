class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[k][n-1-i] = matrix[i][j];
                k++;
            }
            k=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=ans[i][j];
            }
        }
    }
}
