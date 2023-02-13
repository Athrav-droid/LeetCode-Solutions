class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> helper = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(helper.containsKey(nums[i])){
                helper.put(nums[i],helper.get(nums[i]) + 1);
            }else{
                helper.put(nums[i],1);
            }
        }
        for(int key : helper.keySet()){
            if(helper.get(key) == 1) return key;
        }
        return nums[0];
    }
}