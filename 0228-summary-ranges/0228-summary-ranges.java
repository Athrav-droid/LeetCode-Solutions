class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            while((i+1 < n) && (nums[i + 1] == nums[i] + 1)){
                i++;
            }
            if(curr != nums[i]) 
                ans.add(curr+ "->" + nums[i]);
            else{
                ans.add(Integer.toString(curr));
            }
        }
        return ans;
    }
}