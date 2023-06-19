class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length+1];
        int value =0;
        for(int i=0;i<gain.length;i++){
            value = value + gain[i];
            ans[i] = value;
        }
        int finalans = max(ans);
        return finalans;
        }
    public int max(int[] nums){
            int maxi=0;
            for(int i=0;i<nums.length;i++){
                if(maxi<nums[i]){
                    maxi=nums[i];
                }
            }
        return maxi;
    }
}