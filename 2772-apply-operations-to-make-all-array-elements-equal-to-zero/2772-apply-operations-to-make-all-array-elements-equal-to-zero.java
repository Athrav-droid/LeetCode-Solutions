class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int curr = 0;
        for(int i = 0; i <= n - k; i++){
            if(nums[i] == 0) continue;
            if(nums[i] < 0) return false;
            if(nums[i] > 0) curr = nums[i];
            for(int j = i; j < i + k; j++){
                nums[j] -= curr;
            }
        }
        for(int i = n - k; i < n; i++){
            if(nums[i] != 0) return false;
        }
        return true;
    }
}