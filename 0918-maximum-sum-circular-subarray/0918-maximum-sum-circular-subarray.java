class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE, currMax = 0, currMin = 0;
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
            currMax = Math.max(nums[i],currMax + nums[i]);
            max = Math.max(max,currMax);
            currMin = Math.min(nums[i],currMin + nums[i]);
            min = Math.min(min,currMin);
        }
        return max > 0 ? Math.max(max,total - min) : max;
    }
}