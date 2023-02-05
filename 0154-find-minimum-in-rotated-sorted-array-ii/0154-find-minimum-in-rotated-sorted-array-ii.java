class Solution {
    public int findMin(int[] nums) {
        // Arrays.sort(nums);
        // return nums[0];

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return Collections.min(set);
    }
}