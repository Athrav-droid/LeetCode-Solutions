class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        Map<Integer, Pair> map = new HashMap<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map.put(mat[i][j], new Pair(i, j));
            }
        }   
        for(int i = 0; i < arr.length; i++){
            Pair p = map.get(arr[i]);
            row[p.i]++;
            col[p.j]++;
            if(row[p.i] == n || col[p.j] == m) return i;
        }
        return -1;
    }
}
class Pair {
    int i;
    int j;
    Pair (int i, int j){
        this.i = i;
        this.j = j;
    }
}