class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1) return nums;
        int product = 1;
        boolean containsZero = false;
        int everyZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                everyZero++;
                containsZero = true;
            }else{
                product *= nums[i];
            }
        }
        if(everyZero == nums.length) return nums;
        if(everyZero > 1){
            int[] ans = new int[nums.length];
            Arrays.fill(ans,0);
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            if(containsZero){
                if(nums[i] == 0) nums[i] = product;
                else nums[i] = 0;
            }else{
                nums[i] = product / nums[i];
            }
        }
        
        return nums;
    }
}