class Solution {
    public boolean isMatch(String s, String p) {
        int a = s.length(), b = p.length();
        // return helper(s, p, a - 1, b - 1);

        // Boolean[][] dp = new Boolean[a][b];
        // for(Boolean[] row : dp) Arrays.fill(row, null);
        // return helperMem(s, p, a - 1, b - 1, dp);

        // return helperTab(s, p);

        return helperSO(s, p);
    }

    // Recursive Approach
    public boolean helper(String s, String p, int i, int j){
        // Bases Cases
        // 1. Both the string and pattern ended successfully means string can be generated from pattern
        if(i < 0 && j < 0) return true;
        // 2. if string is remaining but pattern ended 
        if(i >= 0 && j < 0) return false;
        // 3. if string is ended but pattern is remaining, also pattern have alphabets other than '*' 
        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return helper(s, p, i - 1, j - 1);
        else if(p.charAt(j) == '*') return (helper(s, p, i - 1, j) || helper(s, p, i, j - 1));
        else return false;
    }

    // Memoization Approach
    public boolean helperMem(String s, String p, int i, int j, Boolean[][] dp){
        // Bases Cases
        // 1. Both the string and pattern ended successfully means string can be generated from pattern
        if(i < 0 && j < 0) return true;
        // 2. if string is remaining but pattern ended 
        if(i >= 0 && j < 0) return false;
        // 3. if string is ended but pattern is remaining, also pattern have alphabets other than '*' 
        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];
        boolean result = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') result = helperMem(s, p, i - 1, j - 1, dp);
        else if(p.charAt(j) == '*') result =  (helperMem(s, p, i - 1, j, dp) || helperMem(s, p, i, j - 1, dp));
        else result = false;

        dp[i][j] = result;
        return result;
    }

    // Tabulation Approach
    public boolean helperTab(String s, String p){
        int a = s.length(), b = p.length();
        // Bases Cases are Handled using 1 based indexing
        Boolean[][] dp = new Boolean[a + 1][b + 1];
        for(Boolean[] row : dp) Arrays.fill(row, false);

        dp[0][0] = true;

        for(int j = 1; j <= b; j++){
            boolean flag = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k - 1) != '*'){ 
                    flag = false;
                    break; 
                }
            }
            dp[0][j] = flag;
        }

        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*') dp[i][j] =  (dp[i - 1][j] || dp[i][j - 1]);
                else dp[i][j] = false;
            }
        }
        return dp[a][b];
    }

    // Space Optimization Approach
    public boolean helperSO(String s, String p){
        int a = s.length(), b = p.length();
        // Bases Cases are Handled using 1 based indexing
        Boolean[] curr = new Boolean[b + 1];
        Boolean[] prev = new Boolean[b + 1];
        
        Arrays.fill(curr, false);
        Arrays.fill(prev, false);

        prev[0] = true;

        for(int j = 1; j <= b; j++){
            boolean flag = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k - 1) != '*'){ 
                    flag = false;
                    break; 
                }
            }
            prev[j] = flag;
        }

        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') curr[j] = prev[j - 1];
                else if(p.charAt(j - 1) == '*') curr[j] =  (prev[j] || curr[j - 1]);
                else curr[j] = false;
            }
            prev = curr.clone();
        }
        return prev[b];
    }
}