class Solution {
    public int lengthOfLIS(int[] nums) {
        // int ans = 0;
        // for(int i=0;i<nums.length-1;i++){
        //     int max = nums[i];
        //     int count = 1;
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[j] > max){
        //             count++;
        //             max = nums[j];
        //         }
        //     }
        //     ans = Math.max(ans,count);
        // }
        // return ans;

        // return helper(nums,0,-1);

        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(nums, 0, -1, dp);
    }
    // public int helper(int[] nums, int curr, int prev){
    //     if(curr == nums.length) return 0; //base case
    //     // include case
    //     int take = 0;
    //     if(prev == -1 || nums[curr] > nums[prev]){
    //         take = 1 + helper(nums, curr + 1, curr);
    //     }
    //     // exclude case
    //     int notTake = helper(nums, curr + 1, prev);
    //     return Math.max(take, notTake);
    // }
    public int helperMem(int[] nums, int curr, int prev, int[][] dp){
        if(curr == nums.length) return 0; //base case

        if(dp[curr][prev + 1] != -1) return dp[curr][prev+1];
        // include case
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + helperMem(nums, curr + 1, curr, dp);
        }
        // exclude case
        int notTake = helperMem(nums, curr + 1, prev, dp);
        return dp[curr][prev+1] = Math.max(take, notTake);
    }
}