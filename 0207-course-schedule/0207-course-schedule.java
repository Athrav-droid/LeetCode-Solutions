class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // My Graph
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        //initializing new arraylist
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        //creating graph
        for(int[] pre : prerequisites){
            graph[pre[0]].add(pre[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(detectCycle(graph, vis, rec, i)) return false;
            }    
        }
        return true;
    }
    public boolean detectCycle(List<Integer>[] graph, boolean[] vis, boolean[] rec, int curr){
        vis[curr] = true;
        if(graph[curr].size() == 0) return false;
        rec[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            int dest = graph[curr].get(i);
            if(rec[dest]) return true;
            else if(!vis[dest]){
                if(detectCycle(graph, vis, rec, dest)) return true;
            }
        }
        rec[curr] = false; //backTracing the recursive stack
        return false;
    }
    // public boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
    //     // Return false if the node is visited and viewed again before completion
    //     if(visited[node] == 1) {
    //         return false;
    //     }
    //     // Return true if the node is completed processing
    //     if(visited[node] == 2) {
    //         return true;
    //     } 
    //     // Mark the node as visited
    //     visited[node] = 1;
    //     // DFS of all the other nodes current "node" is connected to
    //     for(int n : adj[node]) {
    //         if(!dfs(n, visited, adj))
    //             return false;
    //     }
    //     // If no more other nodes for the current "node" mark as completed and return true 
    //     visited[node] = 2; 
    //     return true;
    // }
}