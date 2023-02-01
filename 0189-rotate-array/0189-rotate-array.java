class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[(i+k)%nums.length]=nums[i]; //ans[5,6,7,1,2,3,4]
        }
        for(int i=0; i<ans.length; i++){
            nums[i]=ans[i]; // copying ans to nums as since return type is void.
        }
    }
}