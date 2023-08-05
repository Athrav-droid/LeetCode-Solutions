class Solution {
    public int maximumProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int negValues = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int x = nums[n - 1];
        int y = nums[n - 2];
        int z = nums[n - 3];
        int a = nums[0];
        int b = nums[1];
        return a < 0 && b < 0 ? Math.max(a * b * x, x * y * z) : x * y * z;
    }
}