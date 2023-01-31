class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,new LinkedHashSet<Integer>());
        return ans;
    }
    public void helper(int[] nums,LinkedHashSet<Integer> i){
        if(i.size() == nums.length){
            ans.add(new ArrayList<Integer>(i));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(i.contains(nums[j])) continue;
            i.add(nums[j]);
            helper(nums,i);
            i.remove(nums[j]);
        }
    }
}