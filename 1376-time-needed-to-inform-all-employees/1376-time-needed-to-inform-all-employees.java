class Solution {
    int max = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < manager.length; i++){
            graph.computeIfAbsent(manager[i], value -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        dfs(graph, ans, headID, informTime);
        return max;
    }
    public void dfs(Map<Integer, List<Integer>> graph, int ans, int headID, int[] informTime){
        int informNext = ans + informTime[headID];
        max = Math.max(ans, max);
        if(graph.get(headID) == null) return;
        for(int dest : graph.get(headID)){
            dfs(graph, informNext, dest, informTime);
        }
    }
}