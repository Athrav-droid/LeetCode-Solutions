class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            if(helper(graph, i, color)) ans.add(i);
        }
        return ans;
    }
    // 0: not visited, 1: safe, 2: current node
    public boolean helper(int[][] graph, int curr, int[] color){
        if(color[curr] != 0) return color[curr] == 1;
        color[curr] = 2;
        for(int next : graph[curr]){
            if(!helper(graph, next, color)) return false;
        }
        color[curr] = 1;
        return true;
    }
}