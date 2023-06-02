class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // int currBombxn = bombs[i][0] - bombs[i][2];
                // int currBombxp = bombs[i][0] + bombs[i][2];
                // int currBombyn = bombs[i][1] - bombs[i][2];
                // int currBombyp = bombs[i][1] + bombs[i][2];
                // if(i == j) continue;
                // if((bombs[j][0] > currBombxn && bombs[j][0] < currBombxp) || (bombs[j][1] > currBombyn && bombs[j][1] < currBombyp)){
                //     graph.computeIfAbsent(i, value -> new ArrayList<>()).add(j);
                // }
                if(i == j) continue;
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                // Create a path from node i to node j, if bomb i detonates bomb j.
                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int count = dfs(graph, new boolean[n], i);
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curr){
        int ans = 1;
        visited[curr] = true;
        if(graph.get(curr) != null){
            for(int neigh : graph.get(curr)){
                if(!visited[neigh]){
                    ans += dfs(graph, visited, neigh);
                }
            }
        }
        return ans;
    }
}

// class Solution {
//     public int maximumDetonation(int[][] bombs) {
//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         int n = bombs.length;
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 if(i == j) continue;
//                 int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
//                 int xj = bombs[j][0], yj = bombs[j][1];

//                 if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
//                     graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
//                 }
//             }
//         }
//         int ans = 0;
//         for(int i = 0; i < n; i++){
//             int count = dfs(graph, new HashSet<>(), i);
//             ans = Math.max(ans, count);
//         }
//         return ans;
//     }
//     public int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int curr){
//         int ans = 1;
//         visited.add(curr);
//         if(graph.get(curr) != null){
//             for(int neigh : graph.get(curr)){
//                 if(!visited.contains(neigh)){
//                     ans += dfs(graph, visited, neigh);
//                 }
//             }
//         }
//         return ans;
//     }
// }