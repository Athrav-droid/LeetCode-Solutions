class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int neg = Integer.MIN_VALUE;
        boolean pos = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0) neg = Math.max(neg, nums[i]);
            min = Math.min(min, Math.abs(nums[i]));
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min) pos = true;
        }
        return pos ? min : neg;
    }
}