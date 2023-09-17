class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        if(k == 0) return nums.get(0);
        int ans = 0;
        for(int i = 0; i < nums.size(); i++){
            int j = i;
            int count = 0;
            while(j > 0){
                if((j & 1) == 1) count++;
                j >>= 1;
            }
            if(count == k) ans += nums.get(i);
        }
        return ans;
    }
}