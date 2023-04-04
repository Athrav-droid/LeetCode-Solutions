class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int i = 0;
        int ans = 0;
        while(i < s.length()){
            int zeros = 0, ones = 0;
            while(i < s.length() && s.charAt(i) == '0'){
                zeros++;
                i++;
            }
            while(i < s.length() && s.charAt(i) == '1'){
                ones++;
                i++;
            }
            int min = Math.min(zeros, ones);
            ans = Math.max(ans, 2*min);
        }
        return ans;
    }
}
