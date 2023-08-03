class Solution {
    public boolean isGood(int[] nums) {
        int[] freq = new int[202];
        int max = 0;
        for(int i : nums){
            freq[i]++;
            max = Math.max(max, i);
        }
        if(nums.length != max + 1) return false;
        for(int i = 1; i < 202; i++){
            if(i == max){
                if(freq[i] != 2) return false;
            }else{
                if(freq[i] != 0 && freq[i] != 1) return false;
            }
        }
        return true;
    }
}