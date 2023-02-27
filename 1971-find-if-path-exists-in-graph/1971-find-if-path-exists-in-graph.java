class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == destination) return true;
            for(int i=0;i<graph[curr].size();i++){
                if(!vis[graph[curr].get(i)]){
                    vis[graph[curr].get(i)] = true;
                    q.add(graph[curr].get(i));
                }
            }
        }
        return false;
    }
}