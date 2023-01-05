class Solution {
    public int minOperations(int[][] grid, int x) {
        //added element to list , then sort , then checked consecutive elements if not divisible by x then return -1(not possible) , then mid nikala , mid se har element to minus kra , absolute nikala and x se divide kra , sbhi ko sum m add kra and usko return krdiya coz vo apna final ans h.
        ArrayList<Integer> helper = new ArrayList();
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                helper.add(grid[i][j]);
            }
        }
        Collections.sort(helper);
        for(int i=1;i<helper.size();i++){
            if((helper.get(i)-helper.get(i-1)) %x != 0) return -1;
        }
        int mid = helper.get(helper.size()/2);
        for(int i=0;i<helper.size();i++){
            sum+=(Math.abs(mid - helper.get(i)))/x;
        }
        return sum;
    }
}