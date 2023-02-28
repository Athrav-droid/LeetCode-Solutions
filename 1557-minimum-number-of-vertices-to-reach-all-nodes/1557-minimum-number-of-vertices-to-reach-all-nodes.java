class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] helper = new boolean[n];
        for(List<Integer> edge : edges){
            helper[edge.get(1)] = true;
        }
        for(int i=0; i<n; i++){
            if(!helper[i]) ans.add(i);
        }
        return ans;
        // List<Integer> ans = new ArrayList<>();
        // List<Integer>[] graph = new ArrayList[n];
        // for(int i=0;i<n;i++){
        //     graph[i] = new ArrayList<>();
        // }
        // for(List<Integer> edge : edges){
        //     graph[edge.get(0)].add(edge.get(1));
        // }
        // boolean[] vis = new boolean[n];
        // for(int i = 0; i < n; i++){
        //     if(!vis[i]){
        //         vis[i] = true;
        //         ans.add(i);
        //         helper(n, graph, ans, i, vis);
        //     }
        // }
        // return ans;
    }
    // public void helper(int n, List<Integer>[] graph, List<Integer> ans, int curr, boolean[] vis){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(curr);
    //     ans.add(curr);
    //     vis[curr] = true;
    //     while(!q.isEmpty()){
    //         int a = q.poll();
    //         for(int i=0;i<graph[a].size();i++){
    //             vis[graph[a].get(i)] = true;
    //             q.add(graph[a].get(i));
    //         }
    //     }
    // }
}