class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        // Sbhi rows ko string m convert krke key ki trah use kra h and unki frequency count krli h
        for(int[] row : grid){
            String rowStrings = Arrays.toString(row);
            map.put(rowStrings, 1 + map.getOrDefault(rowStrings, 0));
        }
        // now sbhi colums of Strings m convert krke map m pdi keys se check kr rhe and h to uski frequency ko answer m add krdo else ek new key bnake map m daaldo aage or columns se check krne k liye
        for(int col = 0; col < n; col++){
            int[] colStrings = new int[n];
            for(int row = 0; row < n; row++){
                colStrings[row] = grid[row][col];
            }
            ans += map.getOrDefault(Arrays.toString(colStrings), 0);
        }
        return ans;
    }
}