class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Map m daal do and target m se minus krdo ... agr iske baad num milega map m to un dono ka array bnake ke return krdo nhi to null return krdo
        HashMap<Integer,Integer> helper = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer num = (Integer)(target - nums[i]);
            if(helper.containsKey(num)){
                int[] ans = {helper.get(num),i+1};
                return ans;
            }
            helper.put(nums[i],i+1);
        }
        return null;
    }
}