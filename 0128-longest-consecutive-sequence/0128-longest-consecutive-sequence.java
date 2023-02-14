class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length-1){
                if(Math.abs(nums[i]-nums[i+1]) == 0){
                    i++;
                }else if(Math.abs(nums[i]-nums[i+1]) == 1){
                    i++;count++;
                }else break;
                
            }
            ans = Math.max(ans,count);
            count=0;
        }
        return ans+1;
    }
}