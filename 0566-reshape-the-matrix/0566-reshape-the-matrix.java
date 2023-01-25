class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        ArrayList<Integer> helper = new ArrayList<>();
        int[][] ans = new int[r][c];
        int m = mat.length, n = mat[0].length;
        if(m*n != r*c) return mat;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper.add(mat[i][j]);
            }
        }
        int k = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j] = helper.get(k);
                k++;
            }
        }
        return ans;
    }
}