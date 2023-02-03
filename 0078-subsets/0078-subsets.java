class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,new ArrayList<>(),0,ans);
        return ans;
    }
    public void helper(int[] nums, List<Integer> curr, int index, List<List<Integer>> ans){
        if(ans.contains(curr)) return;
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(nums,curr,index+1,ans);
        curr.remove(curr.size()-1);
        helper(nums,curr,index+1,ans);
    }
}