class Solution {
    // Approach:- We have to think like we are always guessing the wrong answer, so have to add its cost to the answer.
    // We will mark each number as our guess one by one and calculate its result. Since we are calculating for every
    // number and we have to find minimum amount so we will take minimum of every answer. 
    // if we are taking a number x from range [1,n] and assuming its a wrong guess then we will add x to answer and
    // now our range will become [1, x - 1] and [x + 1, n]. Maximum of both these will be our answer so statement will
    // come out as
    // ans = min(ans, x + max(f(1, x-1), f(x+1, n))) for every possible x.
    public int getMoneyAmount(int n) {
        // return helper(1, n);

        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return helperMem(1, n, dp);

        return helperTab(n);
    }

    public int helper(int start, int end){
        if(start >= end) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++){
            ans = Math.min(ans, i + Math.max(helper(start, i - 1), helper(i + 1, end)));
        }
        return ans;
    }

    public int helperMem(int start, int end, int[][] dp){
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++){
            ans = Math.min(ans, i + Math.max(helperMem(start, i - 1, dp), helperMem(i + 1, end, dp)));
        }
        return dp[start][end] = ans;
    }

    public int helperTab(int n){
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp) Arrays.fill(row, 0);

        for(int start = n; start >= 1; start--){
            for(int end = start; end <= n; end++){
                if(start == end) continue; // Base Case:- Since start can not be greater than end but it can be equal
                else{
                    int ans = Integer.MAX_VALUE;

                    for(int i = start; i <= end; i++){
                        ans = Math.min(ans, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                    }
                    dp[start][end] = ans;
                }
            }
        }
        return dp[1][n];
    }
}