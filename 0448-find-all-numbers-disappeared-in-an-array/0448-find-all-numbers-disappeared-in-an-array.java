class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> helper = new HashSet<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            helper.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){
            if(!helper.contains(i)) ans.add(i);
        }
        return ans;
    }
}