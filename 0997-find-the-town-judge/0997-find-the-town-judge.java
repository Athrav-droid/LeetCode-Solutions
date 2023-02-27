class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] out = new boolean[n];
        int[] in = new int[n];
        for(int[] a : trust){
            out[a[0]-1] = true;
            in[a[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(!out[i] && in[i] == n -1) return i+1;
        }
        return -1;
    }
}