class Solution {
    // Questions specify's that we have to make all array elements equal, it doesn't mean we have to make them equal
    // to the elements that are in the array. So we can make them equal to any number just all elements should be equal
    
    // Binary Sum Approach
    public long minCost(int[] nums, int[] cost) {
        // Approach:- We will take the maximum and minimum value from the nums Array
        // we will check the mid value and mid - 1 or mid + 1 value to make all of them equal with their cost.
        // we store the min cost as our answer and will eliminate the side whose cost is higher as we do in Binary S.

        long ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while(min <= max){
            int mid = min + (max - min)/2;
            
            long cost1 = helper(nums, cost, mid);
            long cost2 = helper(nums, cost, mid - 1);
            ans = Math.min(cost1, cost2);

            if(cost1 < cost2){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return ans;
    }

    public long helper(int[] nums, int[] cost, int mid){
        long currCost = 0;
        for(int i = 0; i < nums.length; i++){
            currCost += (long) Math.abs(nums[i] - mid) * cost[i];
        }
        return currCost;
    }
    
    //Prefix Sum Approach
    // public long minCost(int[] nums, int[] cost) {
    //     // Sort integers by values.
    //     int n = nums.length;
    //     int[][] numsAndCost = new int[n][2];
    //     for (int i = 0; i < n; ++i) {
    //         numsAndCost[i][0] = nums[i];
    //         numsAndCost[i][1] = cost[i];
    //     }
    //     Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

    //     // Get the prefix sum array of the costs.
    //     long[] prefixCost = new long[n];
    //     prefixCost[0] = numsAndCost[0][1];
    //     for (int i = 1; i < n; ++i)
    //         prefixCost[i] = numsAndCost[i][1] + prefixCost[i - 1];

    //     // Then we try every integer nums[i] and make every element equals nums[i],
    //     // Start with nums[0]
    //     long totalCost = 0l;
    //     for (int i = 1; i < n; ++i)
    //         totalCost += 1l * numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
    //     long answer = totalCost;
        
    //     // Then we try nums[1], nums[2] and so on. The cost difference is made by the change of
    //     // two parts: 1. prefix sum of costs. 2. suffix sum of costs. 
    //     // During the iteration, record the minimum cost we have met.
    //     for (int i = 1; i < n; ++i) {
    //         int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
    //         totalCost += 1l * prefixCost[i - 1] * gap;
    //         totalCost -= 1l * (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
    //         answer = Math.min(answer, totalCost);
    //     }
        
    //     return answer;
    // }
}