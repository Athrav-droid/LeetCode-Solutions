class Solution {
    public int minimizeArrayValue(int[] nums) {
        // int ans = nums[0];
        // for(int i = nums.length - 1; i >= 1; i--){
        //     if(nums[i] > nums[i-1] && nums[i] > 0){
        //         int diff = nums[i] - nums[i-1];
        //         nums[i] -= diff/2;
        //         nums[i-1] += diff/2;
        //         ans = Math.max(ans, Math.max(nums[i], nums[i-1]));
        //     }
        // }
        // return ans;

        long sum = 0, ans = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            ans = Math.max(ans, (sum + i) / (i + 1));
        } 
        return (int)ans;
    }
}
