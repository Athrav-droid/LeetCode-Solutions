class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j;
        for (j = 0; j < n; ++j){
            // we are calculating the numbers which cannot be made equal
            if (nums[j] - nums[i] > k * 2){
                i++;
            }
        }
        return j - i;
    }
}