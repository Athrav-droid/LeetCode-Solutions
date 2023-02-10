class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){ // if length 1 then return 0;
            return 0;
        }
        int max = 0; // for max jump taking from an element
        int curr = 0; // curr to updating to max so till we reach curr(max), skip all elements
        int count = 0; // this is ans
        for(int i = 0 ; i < nums.length - 1 ; i++){
            max = Math.max(max , i + nums[i]); // updating the max we can reach from the particular value and keeping track of the max value
            if(curr == i){ // reaching till the max value skipping the elements and count++ only when we reach the max index
                curr = max;
                count++;
            }
            if(curr>nums.length-1){
                return count;
            }
        }
        return count;
    }
}