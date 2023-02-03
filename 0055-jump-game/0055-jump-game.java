class Solution {
    public boolean canJump(int[] nums) {
        //question says that from the minimum index find the maximum jump that can make you reach the last index of the array or go beyond the array, if there not any index like that then return false and if found return true;
        int maxPos=0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxPos){
                maxPos = Math.max(maxPos,i+nums[i]);
                if(maxPos >= nums.length - 1) return true;
            }
        }
        return false;
    }
}