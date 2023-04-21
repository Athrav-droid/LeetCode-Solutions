class Solution {
    public int combinationSum4(int[] nums, int target) {
        // return helper(nums, target);

        // int[] dp = new int[target+1];
        // Arrays.fill(dp, -1);
        // return helperMem(nums, target, dp);

        return helperTab(nums, target);
    }
    // public int helper(int[] nums, int target){
    //     if(target < 0) return 0;
    //     if(target == 0) return 1;
    //     int ans = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         ans += helper(nums, target - nums[i]);
    //     }
    //     return ans;
    // }

    // public int helperMem(int[] nums, int target, int[] dp){
    //     if(target < 0) return 0;
    //     if(target == 0) return 1;
    //     if(dp[target] != -1) return dp[target];
    //     int ans = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         ans += helperMem(nums, target - nums[i], dp);
    //     }
    //     return dp[target] = ans;
    // }

    public int helperTab(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //traversing from one to target
        for(int i = 1; i <= target; i++){
            //traversing on num vector
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0) dp[i] += dp[i - nums[j]];  
            }
        }
        return dp[target];
    }
}