    class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        // Using Power array to avoid calculating of no. of subseq more and more time, as we know that no of subseq
        // for particular number of subsequence will be 2^n;
        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++) power[i] = (power[i - 1] * 2) % mod;
        for(int left = 0; left < n; left++){
            // finding the just smallest number, greater than target and then - 1 gives previous value 
            int right = binarySearch(nums, target - nums[left]) - 1;
            if(right >= left) ans = (ans + power[right - left]) % mod;
        }
        return ans;
    }
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}