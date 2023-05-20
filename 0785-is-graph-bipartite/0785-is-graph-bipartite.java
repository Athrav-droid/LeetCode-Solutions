class Solution {
    // If the node is in the same component as its neighbors, then they are in the same set and --
    // -- the graph is not bipartite.
    // Bipartite means each node can only be connected to a node in another set/component
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        for(int i = 0; i < graph.length; i++){
            int[] edges = graph[i];
            for(int edge : edges){
                if(uf.find(edge) == uf.find(i)) return false;
                // doesn't matter who in this group will be parent. The point is that they all are in the same group set.
                // therefore we used here edges[0] we can also use any other edges
                uf.union(edges[0], edge);
            }
        }
        return true;
    }

    public class UnionFind {
        private int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int node){
            if(parent[node] == node) return node;
            else return find(parent[node]);
        }

        public void union(int n1, int n2){
            int par1 = find(n1);
            int par2 = find(n2);
            if(par1 != par2) parent[par1] = par2;
        }
    }
}