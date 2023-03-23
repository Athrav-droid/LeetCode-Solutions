class Solution {
    public int makeConnected(int n, int[][] connections) {
        int stronglyConnected = -1;
        if(connections.length < n - 1) return -1;
        boolean[] vis = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] connection : connections){
            graph.computeIfAbsent(connection[0], value -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], value -> new ArrayList<>()).add(connection[0]);
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                stronglyConnected++;
                dfs(graph, vis, i, -1);
            }
        }
        return stronglyConnected;
    }
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;
        if(graph.get(curr) != null){
            for(int dest : graph.get(curr)){
                if(dest == parent) continue;
                if(!vis[dest]){
                    dfs(graph, vis, dest, curr);
                }
            }
        }
    }
}