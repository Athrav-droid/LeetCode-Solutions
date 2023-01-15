class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<=queries[i][2];j++){
                for(int k=queries[i][1];k<=queries[i][3];k++){
                    ans[j][k]++;
                }
            }
        }
        return ans;
    }
}