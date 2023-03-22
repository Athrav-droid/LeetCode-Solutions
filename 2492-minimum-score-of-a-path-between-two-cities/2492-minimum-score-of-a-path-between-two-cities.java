class Solution {
    int min = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] road : roads){
            adjList.computeIfAbsent(road[0], value -> new ArrayList<>()).add(new int[] {road[1], road[2]});
            adjList.computeIfAbsent(road[1], value -> new ArrayList<>()).add(new int[] {road[0], road[2]});
        }
        boolean[] vis = new boolean[n+1];
        Arrays.fill(vis, false);
        dfs(1, adjList, vis);
        return min;
    }
    public void dfs(int curr, Map<Integer, List<int[]>> adjList, boolean[] vis){
        vis[curr] = true;
        if(!adjList.containsKey(curr)) return;
        for(int[] adj : adjList.get(curr)){
            min = Math.min(min, adj[1]);
            if(!vis[adj[0]]){
                dfs(adj[0], adjList, vis);
            }
        }
    }
}