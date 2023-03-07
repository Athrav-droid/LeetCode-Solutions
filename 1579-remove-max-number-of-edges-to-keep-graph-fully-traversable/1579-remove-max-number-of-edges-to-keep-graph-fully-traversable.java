class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int totalEdgesReq = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
                totalEdgesReq += Alice.union(edge[1], edge[2]);
                Bob.union(edge[1], edge[2]);
            }
        }
        for(int[] edge : edges){
            if(edge[0] == 1){
                totalEdgesReq += Alice.union(edge[1], edge[2]);
            }else if(edge[0] == 2){
                totalEdgesReq += Bob.union(edge[1], edge[2]);
            }
        }
        if(!Alice.checkConnection() || !Bob.checkConnection()) return -1;
        return edges.length - totalEdgesReq;
    }
    private class UnionFind {
        int[] parent;
        int[] size;
        int components;

        public UnionFind(int n){ // class constructor
            parent = new int[n+1];
            size = new int[n+1];
            components = n;
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int edge){ // method to find parent node of the current node
            if(parent[edge] == edge) return edge;
            return parent[edge] = find(parent[edge]);
        }

        int union(int edge1, int edge2){ // method to put two connected edges in one set
            edge1 = find(edge1);
            edge2 = find(edge2);

            if(edge1 == edge2) return 0;
            if(size[edge1] > size[edge2]){
                size[edge1] += size[edge2];
                parent[edge2] = edge1;
            }else{
                size[edge2] += size[edge1];
                parent[edge1] = edge2;
            }
            components--;
            return 1;
        }

        boolean checkConnection(){ // check if the whole graph is connected or not
            return components == 1;
        }

    }
}