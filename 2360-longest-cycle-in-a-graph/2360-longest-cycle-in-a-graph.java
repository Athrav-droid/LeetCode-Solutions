class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, vis);
            }
        }
        return ans;
    }
    public void dfs(int curr, int[] edges, Map<Integer, Integer> dist, boolean[] vis){
        vis[curr] = true;
        int neigh = edges[curr];
        if(neigh != -1 && !vis[neigh]){
            dist.put(neigh, dist.get(curr) + 1);
            dfs(neigh, edges, dist, vis);
        }else if(neigh != -1 && dist.containsKey(neigh)){
            ans = Math.max(ans, dist.get(curr) - dist.get(neigh) + 1);
        }
    }
}