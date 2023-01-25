class Solution {
    public int countNegatives(int[][] grid) {
        // //Approach one 
        // int m = grid.length - 1;
        // int n = grid[m].length;
        // int ans = 0;
        // for(int i=0;i<=m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j] < 0) ans++;
        //     }
        // }
        // return ans;

        // Approach two
        int ans = 0;
        for(int[] row: grid){
            ans += helper(row);
        }
        return ans;
        
    }
    public int helper(int[] grid){
            int low = 0;
            int high = grid.length - 1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(grid[mid] >= 0) low = mid + 1;
                else high = mid - 1;
            }
            return grid.length - high -1; //high is the last positive index ( 0 based index )
    }
}