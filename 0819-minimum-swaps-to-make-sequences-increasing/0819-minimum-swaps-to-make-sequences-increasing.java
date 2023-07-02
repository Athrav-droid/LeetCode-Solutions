class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        // return helper(nums1, nums2, 0, false);

        int[][] dp = new int[nums1.length][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(nums1, nums2, 0, false, dp);

        // return helperTab(nums1, nums2);
    }

    // RECURSIVE METHOD
    public int helper(int[] nums1, int[] nums2, int index, boolean swapped){
        if(index == nums1.length) return 0;
        int ans = Integer.MAX_VALUE;
        int prev1 = index == 0 ? -1 : nums1[index - 1];
        int prev2 = index == 0 ? -1 : nums2[index - 1];
        
        System.out.println(prev1);
        System.out.println(prev2);
        if(swapped){
            int temp = prev1; 
            prev1 = prev2;
            prev2 = temp;
        }
        System.out.println(prev1);
        System.out.println(prev2);
        if(nums1[index] > prev1 && nums2[index] > prev2) 
            ans = helper(nums1, nums2, index + 1, false);
        if(nums1[index] > prev2 && nums2[index] > prev1)
            ans = Math.min(ans, 1 + helper(nums1, nums2, index + 1, true));
        return ans;
    }

    // MEMOIZATION METHOD
    public int helperMem(int[] nums1, int[] nums2, int index, boolean swapped, int[][] dp){
        if(index == nums1.length) return 0;
        int ans = Integer.MAX_VALUE;
        int prev1 = index == 0 ? -1 : nums1[index - 1];
        int prev2 = index == 0 ? -1 : nums2[index - 1];
        if(dp[index][swapped ? 1 : 0] != -1) return dp[index][swapped ? 1 : 0];

        if(swapped){
            int temp = prev1; 
            prev1 = prev2;
            prev2 = temp;
        }
        if(nums1[index] > prev1 && nums2[index] > prev2) 
            ans = helperMem(nums1, nums2, index + 1, false, dp);
        if(nums1[index] > prev2 && nums2[index] > prev1)
            ans = Math.min(ans, 1 + helperMem(nums1, nums2, index + 1, true, dp));
        return dp[index][swapped ? 1 : 0] = ans;
    }

    // TABULATION METHOD :-    BOTTOM UP DP
    public int helperTab(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length + 1][2];
        for(int[] row : dp) Arrays.fill(row, 0);

        for(int index = nums1.length - 1; index >= 1; index--){
            for(int swapped = 1; swapped >= 0; swapped--){
                int ans = Integer.MAX_VALUE;
                int prev1 = index == 0 ? -1 : nums1[index - 1];
                int prev2 = index == 0 ? -1 : nums2[index - 1];

                if(swapped == 1){
                    int temp = prev1; 
                    prev1 = prev2;
                    prev2 = temp;
                }
                if(nums1[index] > prev1 && nums2[index] > prev2) 
                    ans = dp[index + 1][0];
                if(nums1[index] > prev2 && nums2[index] > prev1)
                    ans = Math.min(ans, 1 + dp[index + 1][1]);
                dp[index][swapped] = ans;
            }
        }
        return dp[1][0];
    }
}