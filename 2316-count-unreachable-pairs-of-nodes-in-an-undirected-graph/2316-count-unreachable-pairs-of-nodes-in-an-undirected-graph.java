class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }
        Map<Integer, Integer> count = new HashMap<>();
        int stronglyConnected = -1;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                stronglyConnected++;
                dfs(graph, i, stronglyConnected, count, vis);
            }
        }
        if(stronglyConnected == 0) return 0;
        long remain = 0;
        for(int i = 0; i < count.size() - 1; i++){
            remain += count.get(i);
            ans += count.get(i) * (n - remain);
        }
        return ans;
    }
    public void dfs(Map<Integer, List<Integer>> graph, int curr, int stronglyConnected, Map<Integer, Integer> count, boolean[] vis){
        vis[curr] = true;
        count.put(stronglyConnected, count.getOrDefault(stronglyConnected, 0) + 1);
        if(graph.get(curr) != null){
            for(int dest : graph.get(curr)){
                if(!vis[dest]){
                    dfs(graph, dest, stronglyConnected, count, vis);
                }
            }
        }
    }
}