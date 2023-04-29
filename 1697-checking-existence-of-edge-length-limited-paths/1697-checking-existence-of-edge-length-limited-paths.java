class UnionFind {
    private int[] group;
    private int[] rank;

    UnionFind(int size){
        group = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; ++i) group[i] = i;
    }

    public int find(int node){
        if(group[node] != node){
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public void join(int n1, int n2){
        int group1 = find(n1);
        int group2 = find(n2);

        //already in same group
        if(group1 == group2) return;

        // if not in same group then check which node have higher rank and make them grouped with higher rank
        if(rank[group1] > rank[group2]){
            group[group2] = group1;
        }else if(rank[group1] < rank[group2]){
            group[group1] = group2;
        }else{
            group[group1] = group2;
            rank[group2] += 1;
        }
    }

    // checking if both nodes belong to same group or not, if yes means they can be reached.
    public boolean isConnected(int n1, int n2){
        return find(n1) == find(n2);
    }

}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        UnionFind uf = new UnionFind(n);
        int m = queries.length; // queries Array length

        // since we will sort array so they will lose their original index so we are storing their original index with them
        // so that we can store that queries's ans on the correct index
        int[][] queriesWithIndex = new int[m][4];
        for(int i = 0; i < m; ++i){
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        // sorting both list on basis of weight
        sort(edgeList);
        sort(queriesWithIndex);

        int edgeIndex = 0;

        for(int index = 0; index < m; index++){
            int p = queriesWithIndex[index][0];
            int q = queriesWithIndex[index][1];
            int limit = queriesWithIndex[index][2];
            int originalIndex = queriesWithIndex[index][3];

            // We can attach all edges which satisfy the limit given by the query.
            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit){
                int n1 = edgeList[edgeIndex][0];
                int n2 = edgeList[edgeIndex][1];
                uf.join(n1, n2);
                edgeIndex += 1;
            }

            ans[originalIndex] = uf.isConnected(p, q);
        }
        return ans;
    }

    private void sort(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
    }
}