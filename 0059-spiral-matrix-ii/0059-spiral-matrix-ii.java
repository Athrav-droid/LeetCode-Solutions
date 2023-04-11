class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 0, l = 0, currVal = 1, m = n;
        while(k < m && l < n){
            for(int i=l;i<n;i++){
                matrix[k][i] = currVal;
                currVal++;
            }
            k++;
            for(int i=k;i<m;i++){
                matrix[i][n-1] = currVal;
                currVal++;
            }
            n--;
            if(k<m){
            //left
            for(int i=n-1;i>=l;i--){
                matrix[m-1][i] = currVal;
                currVal++;
            }
            m--;
            }
            
            //top
            if(l<n){
            for(int i=m-1;i>=k;i--){
                matrix[i][l] = currVal;
                currVal++;
            }
            l++;
            }
        }
        return matrix;
    }
}