class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                ans++;
                dfs(isConnected, vis, i);
            }
        }
        return ans;
    }
    public void dfs(int[][] isConnected, boolean[] vis, int i){
        vis[i] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(!vis[j] && isConnected[i][j] == 1) dfs(isConnected, vis, j);
        }
    }
}