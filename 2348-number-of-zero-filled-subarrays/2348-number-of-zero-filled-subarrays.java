class Solution {
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            while(i < nums.length && nums[i] == 0){
                count++;
                i++;
            }
            if(count != 0) zeros.add(count);
        }
        long ans = 0;
        for(int val : zeros){
            ans += helper((long)val);
        }
        return ans;
    }
    public long helper(long val){
        if(val == 1) return 1;
        if(val == 2) return 3;
        return (val * (val + 1))/2;
    }
}