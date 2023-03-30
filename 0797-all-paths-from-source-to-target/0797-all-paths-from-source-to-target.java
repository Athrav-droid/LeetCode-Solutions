class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                map.computeIfAbsent(i, value -> new ArrayList<>()).add(graph[i][j]);
            }
        }
        dfs(map, 0, n-1, new ArrayList<>());
        return ans;
    }
    public void dfs(Map<Integer, List<Integer>> map, int src, int dest, List<Integer> temp){
        temp.add(src);
        if(src == dest){
            ans.add(temp);
            return;
        }
        if(map.get(src) != null){
            for(int curr : map.get(src)){
                dfs(map, curr, dest, new ArrayList<>(temp));
            }
        }
    }
}