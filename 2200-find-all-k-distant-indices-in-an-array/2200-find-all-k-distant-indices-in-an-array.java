class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> helper = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key) helper.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < helper.size(); j++){
                if( (Math.abs(i - helper.get(j)) <= k) ){
                    ans.add(i);
                    break;
                }
            } 
        }
        return ans;
    }
}