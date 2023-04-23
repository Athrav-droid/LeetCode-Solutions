class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        // return helperRec(s, k, 0);

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return helperMem(s, k, 0, dp);

        // return helperTab(s, k);
    }
    // public int helperRec(String s, int k, int index){
    //     if(index == s.length()) return 1;
    //     if(s.charAt(index) == '0') return 0;
    //     int ans = 0;
    //     int num = 0;
    //     for(int i = index; i < s.length(); i++){
    //         num = num * 10 + (s.charAt(i) - '0');
    //         if(num > k) break;
    //         ans = (ans + helperRec(s, k, i + 1)) % mod;
    //     }
    //     return ans;
    // }

    public int helperMem(String s, int k, int index, int[] dp){
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != -1) return dp[index];
        int ans = 0;
        long num = 0;
        for(int i = index; i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num > k) break;
            ans = (ans + helperMem(s, k, i + 1, dp)) % mod;
        }
        return dp[index] = ans % mod;
    }

    // public int helperTab(String s, int k){
    //     int[] dp = new int[s.length() + 1];
    //     dp[0] = 1;
    //     int num = 0;
    //     for(int start = 0; start < s.length(); ++start){
    //         if(s.charAt(start) == '0') continue;
    //         for(int end = start; end < s.length(); end++){
    //             String curr = s.substring(start, end + 1);
    //             if(Long.parseLong(curr) > k) break;
    //             dp[end + 1] = (dp[end + 1] + dp[start])% mod;
    //         }
    //     }
    //     return dp[s.length()];
    // }
}