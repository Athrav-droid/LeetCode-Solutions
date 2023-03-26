class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int[] edge : edges){
            if(find(edge[0]) == find(edge[1])) return edge;
            union(edge[0], edge[1]);
        }
        return null;
    }
    public int find(int node){
        while(parent[node] != node) node = parent[node];
        return node;
    }
    public void union(int node1, int node2){
        int par1 = find(node1);
        int par2 = find(node2);
        if(par1 != par2){
            parent[par2] = par1;
        }
    }
}