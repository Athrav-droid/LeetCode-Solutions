class Solution {
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max_val = Integer.MIN_VALUE, max_end = 0;
        for(int i=0;i<nums.length;i++){
            max_end = max_end + nums[i];
            if(max_val < max_end) max_val = max_end;
            if(max_end < 0) max_end = 0;
        }
        return max_val;
    }
}