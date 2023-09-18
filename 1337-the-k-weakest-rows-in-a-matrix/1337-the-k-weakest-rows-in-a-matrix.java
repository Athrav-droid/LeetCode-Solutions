class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int n = mat.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) count++;
            }
            temp[i] = count;
        }
        int p = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = 0; j < n; j++){
                if(p == k) return ans;
                if(temp[j] == i){
                    ans[p++] = j;
                }
            }
        }
        return ans;
    }
}