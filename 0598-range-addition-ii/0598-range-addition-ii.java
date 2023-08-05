class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //  BRUTE FORCE :- MEMORY LIMIT EXCEEDED
        // if(ops.length == 0) return m * n;
        // int max = 0;
        // int[][] numbers = new int[m][n];
        // for(int[] op : ops){
        //     int x = op[0];
        //     int y = op[1];

        //     for(int i = 0; i < x; i++){
        //         for(int j = 0; j < y; j++){
        //             numbers[i][j]++;
        //             max = Math.max(numbers[i][j], max);
        //         }
        //     }
        // }
        // int count = 0;
        // for(int i = 0; i < m ; i++){
        //     for(int j = 0; j < n; j++){
        //         if(numbers[i][j] == max) count++;
        //     }
        // }
        // return count;

        if(ops.length == 0) return m * n;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++){
            x = Math.min(x, ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }
        return x * y;
    }
}