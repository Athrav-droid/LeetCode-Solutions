class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // BRUTE FORCE O(n^2)
        // int ans = 0;
        // for(int i = 0; i < nums.length; i++){
        //     int min = nums[i], max = nums[i];
        //     for(int j = i; j < nums.length; j++){
        //         if(nums[j] < minK || nums[j] > maxK) break;
        //         min = Math.min(min, nums[j]);
        //         max = Math.max(max, nums[j]);
        //         if(min == minK && max == maxK) ans++;
        //     }
        // }
        // return ans;

        //TWO POINTER APPROACH O(n) .. official solution
        long ans = 0;
        int min = -1, max = -1, leftbound = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK) leftbound = i;
            if(nums[i] == minK) min = i;
            if(nums[i] == maxK) max = i;
            ans += Math.max(0, Math.min(min, max) - leftbound);
        }
        return ans;
    }
}