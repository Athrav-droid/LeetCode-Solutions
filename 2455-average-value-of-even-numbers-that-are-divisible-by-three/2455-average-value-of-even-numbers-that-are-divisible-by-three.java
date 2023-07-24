class Solution {
    public int averageValue(int[] nums) {
        int ans = 0;
        int len = 0;
        for(int i : nums){
            if(i % 3 == 0 && i % 2 == 0){
                len++;
                ans += i;
            }
        }
        return len == 0 ? 0 : ans / len;
    }
}