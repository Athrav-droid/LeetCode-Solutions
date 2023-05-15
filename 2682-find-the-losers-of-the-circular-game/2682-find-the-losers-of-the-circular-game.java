class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean visited[] = new boolean[n];
        int v = 0, curr = 0;
        while(!visited[curr % n]){
            v++;
            visited[curr % n] = true;
            curr += v*k;
        }
        int[] res = new int[n-v];
        int j=0;
        for(int i=0; i<visited.length; i++){
            if(visited[i] == false) res[j++]=i+1;
        }
        return res;
    }
}