class Solution {
    // int ans = 0;
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // helper(nums, 0, 0, target);
        // return ans;

        for(int a : nums){
            total += a;
        }
        int[][] dp = new int[nums.length][2 * total + 1];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helperMem(nums, 0, 0, target, dp);

        // return helperTab(nums, target);

        // return helperSO(nums, target);
    }

    // Recursive Method
    // public void helper(int[] nums, int i, int sum, int target){
    //     if(i == nums.length){
    //         if(sum == target) ans++;
    //     }else{
    //         helper(nums, i + 1, sum + nums[i], target);
    //         helper(nums, i + 1, sum - nums[i], target);
    //     }
    // }

    // Memoization Method
    public int helperMem(int[] nums, int i, int sum, int target, int[][] dp){
        if(i == nums.length){
            if(sum == target) return 1;
            else return 0;
        }else{
            if(dp[i][sum + total] != Integer.MIN_VALUE) return dp[i][sum + total];
            int pos = helperMem(nums, i + 1, sum + nums[i], target, dp);
            int neg = helperMem(nums, i + 1, sum - nums[i], target, dp);
            return dp[i][sum + total] = pos + neg;
        }
    }

    // Tabulation Method
    public int helperTab(int[] nums, int target){
        int total = Arrays.stream(nums).sum(); // sum of the array, so that we don't go out of array anytime
        int[][] dp = new int[nums.length][2 * total + 1]; // 2 * total because we have both positive and negative vals

        // Base Values
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;

        // first loop to iterate over remaining value of the nums array
        for(int i = 1; i < nums.length; i++){
            // second loop that iterates over the possible sums (sum) from -total to total. This loop considers 
            // all possible sums that can be formed by adding or subtracting the previous elements.
            for(int sum = -total; sum <= total; sum++){
                // an if condition to check if there are any ways to reach the current sum at index i-1 in the dp
                // array. If the value at dp[i - 1][sum + total] is greater than 0, it means that there are ways 
                // to reach the current sum.
                if(dp[i - 1][sum + total] > 0){
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        // if absolute value of target is greater than total of nums, means the target is not acheivable by the
        // value of nums array so return 0 
        return Math.abs(target) > total ? 0 : dp[nums.length - 1][target + total];
    }

    //Space Optimization
    // Looking at the tabulation solution we can say that current row of dp only requires the last row of dp. so we
    // can save some space here by creating new array in every loop call and just updating the value of array at the
    // last of nested loop everytime.
    public int helperSO(int[] nums, int target){
        int total = Arrays.stream(nums).sum();
        int[] dp = new int[2 * total + 1];
        dp[nums[0] + total] = 1;
        dp[-nums[0] + total] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * total + 1];
            for (int sum = -total; sum <= total; sum++) {
                if (dp[sum + total] > 0) {
                    next[sum + nums[i] + total] += dp[sum + total];
                    next[sum - nums[i] + total] += dp[sum + total];
                }
            }
            dp = next;
        }
        return Math.abs(target) > total ? 0 : dp[target + total];
    }
}