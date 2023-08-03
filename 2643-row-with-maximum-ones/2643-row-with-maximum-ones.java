class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] freq = new int[mat.length];
        int maxRow = 0;
        int maxOcc = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) freq[i]++;
                if(freq[i] > maxOcc){
                    maxOcc = freq[i];
                    maxRow = i;
                }
            }
        }
        int[] ans = {maxRow, maxOcc};
        return ans;
    }
}