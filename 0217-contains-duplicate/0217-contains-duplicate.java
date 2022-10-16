class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupli = new HashSet<Integer>();
        for (int idx = 0; idx < nums.length; idx ++){
            if (dupli.contains(nums[idx])){
                return true;
            }
            dupli.add(nums[idx]);
        }
        return false;
    }
}