class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, k, ans, new ArrayList<>());
        return ans.size();
    }
    public void helper(int index, int[] nums, int k, List<List<Integer>> ans, List<Integer> temp){
        if(index == nums.length){
            if(temp.size() > 0) ans.add(new ArrayList<>(temp));
            return;
        }
        // using of arraylist gives benefit of contains function to check whether any two number are not to be present in list if their difference is k
        if(!temp.contains(nums[index] - k)){
            temp.add(nums[index]);
            helper(index + 1, nums, k, ans, temp);
            temp.remove(temp.size()-1);
        }
        //if it contains then just call the next index operation.
        helper(index + 1, nums, k, ans, temp);
    }
}