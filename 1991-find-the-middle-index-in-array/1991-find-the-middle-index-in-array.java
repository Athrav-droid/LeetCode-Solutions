class Solution {
    public int findMiddleIndex(int[] nums) {
        // prefix sum approach here
        // https://leetcode.com/problems/find-pivot-index/description/
        
        int leftSum = 0;
        int rightSum = 0;
        for(int i : nums) rightSum += i;

        for(int i = 0; i < nums.length; i++){
            rightSum -= nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}