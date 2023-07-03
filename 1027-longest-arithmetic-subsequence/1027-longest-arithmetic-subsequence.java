class Solution {
    public int longestArithSeqLength(int[] nums) {
        // Commented Code for Recursive Helper Function
        // int n = nums.length;
        // // Base Condition 
        // if(n <= 2) return n; // if there are only one element or two element then that must be the A.P.
        
        // int ans = 0;

        // // checking Every Pair of variable with their difference and their A.P length if maximum or not.
        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j < n; j++){
        //         // 2 + func, because we are taking pair, if two numbers are in A.P then we will add length 2 to answer.
        //         ans = Math.max(ans, 2 + helper(i, nums[j] - nums[i], nums));
        //     }
        // }
        // return ans;

        return helperTab(nums);
    }

    public int helper(int index, int diff, int[] nums){
        // Base Case if index gets out of the array
        if(index < 0) return 0;

        int ans = 0;
        for(int j = index - 1; j >= 0; j--){
            if((nums[index] - nums[j]) == diff)
                ans = Math.max(ans, 1 + helper(j, diff, nums));
        }
        return ans;
    }

    public int helperTab(int[] nums){
        int n = nums.length;
        if(n <= 2) return n;
        
        int ans = 0;
        // Map will give the answer of just backside of i
        // 1 2 3 4 5 6 is array and if we are at 3 then dp will give optimized answer to us till 2 so we don't have to caluclate it again
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>();
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                int count = 1; 

                // checking for answer if already present, using get Or Default method
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
                
            }
        }
        return ans;
    }
    
}