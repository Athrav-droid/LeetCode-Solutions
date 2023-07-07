class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0, right = 0;
        int count = 0;

        while(right < n){
            if(nums[right] == 0) count++;
            while(count > k){
                if(nums[left] == 0) count--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}