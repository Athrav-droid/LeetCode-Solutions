class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            String curr = strs[i];
            for(int j = i + 1; j < n; j++){
                String next = strs[j];
                if(helper(curr, next)){
                    graph.computeIfAbsent(i, value -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, value -> new ArrayList<>()).add(i);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(graph, i, vis);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> graph, int curr, boolean[] vis){
        vis[curr] = true;
        if(graph.get(curr) != null){
            for(int a : graph.get(curr)){
                if(!vis[a]) dfs(graph, a, vis);
            }
        }
    }

    public boolean helper(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) diff++;
        }
        if(diff == 0 || diff == 2) return true;
        else return false;
    }
}