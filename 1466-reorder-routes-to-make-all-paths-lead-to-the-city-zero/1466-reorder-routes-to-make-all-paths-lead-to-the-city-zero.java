class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        // boolean[] vis = new boolean[n];
        // // List<Integer> towardsZero = new ArrayList<>();
        // Map<Integer, List<Integer>> graph = new HashMap<>();
        // for(int[] connection : connections){
        //     graph.computeIfAbsent(connection[0], value -> new ArrayList<>()).add(connection[1]);
        //     // if(connection[1] == 0) towardsZero.add(connection[0]);
        // }
        // for(int i = 0; i < n; i++){
        //     if(!vis[i]){
        //         dfs(graph, vis, i, -1);
        //     }
        // }
        // return n - ans;

        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for(int [] connection : connections){
            graph.computeIfAbsent(connection[0], value -> new ArrayList<>()).add(Arrays.asList(connection[1], 1));
            graph.computeIfAbsent(connection[1], value -> new ArrayList<>()).add(Arrays.asList(connection[0], 0));
        }
        bfs(0, n, graph);
        return ans;
    }
    public void bfs(int curr, int n, Map<Integer, List<List<Integer>>> graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(curr);
        vis[curr] = true;
        while(!q.isEmpty()){
            curr = q.poll();
            if(!graph.containsKey(curr)) continue;
            for(List<Integer> neigh : graph.get(curr)){
                int neighbour = neigh.get(0);
                if(!vis[neighbour]){
                    ans += neigh.get(1);
                    vis[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
    }
    // public void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int curr, int parent){
    //     vis[curr] = true;
    //     if(parent == -1) ans++;
    //     if(graph.get(curr) != null){
    //         for(int dest : graph.get(curr)){
    //             if(dest == parent) continue;
    //             if(!vis[dest]){
    //                 dfs(graph, vis, dest, curr);
    //             }
    //         }
    //     }
    // }
}