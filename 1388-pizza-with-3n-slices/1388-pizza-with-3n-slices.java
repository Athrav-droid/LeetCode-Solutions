class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int ans = 0;
        if(n == 3){
            for(int a : slices) ans = Math.max(ans, a);
            return ans;
        }
        // int fromZero = helperRec(slices, 0, n - 2, n / 3);
        // int fromOne = helperRec(slices, 1, n - 1, n / 3);
        // return Math.max(fromZero, fromOne);

        // int[][] dp = new int[n + 1][n];
        // int[][] dp1 = new int[n + 1][n];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // for(int[] row : dp1) Arrays.fill(row, -1);
        // int fromZero = helperMem(slices, 0, n - 2, n / 3, dp);
        // int fromOne = helperMem(slices, 1, n - 1, n / 3, dp1);
        // return Math.max(fromZero, fromOne);

        // return helperTab(slices);

        return helperSO(slices);
    }

    public int helperRec(int[] slices, int start, int end, int slice){
        if(slice == 0 || start > end) return 0;
        int take = slices[start] + helperRec(slices, start + 2, end, slice - 1);
        int notTake = 0 + helperRec(slices, start + 1, end, slice);
        return Math.max(take, notTake);
    }

    public int helperMem(int[] slices, int start, int end, int slice, int[][] dp){
        if(slice == 0 || start > end) return 0;
        if(dp[start][slice] != -1) return dp[start][slice];
        int take = slices[start] + helperMem(slices, start + 2, end, slice - 1, dp);
        int notTake = 0 + helperMem(slices, start + 1, end, slice, dp);
        return dp[start][slice] = Math.max(take, notTake);
    }

    public int helperTab(int[] slices){
        int n = slices.length;
        int[][] dp = new int[n + 2][n];
        int[][] dp1 = new int[n + 2][n];

        for(int start = n - 2; start >= 0; start--){
            for(int slice = 1; slice <= n/3; slice++){
                int take = slices[start] + dp[start + 2][slice - 1];
                int notTake = 0 + dp[start + 1][slice];
                dp[start][slice] = Math.max(take, notTake);
            }
        }
        int case1 = dp[0][n/3];

        for(int start = n - 1; start >= 1; start--){
            for(int slice = 1; slice <= n/3; slice++){
                int take = slices[start] + dp1[start + 2][slice - 1];
                int notTake = 0 + dp1[start + 1][slice];
                dp1[start][slice] = Math.max(take, notTake);
            }
        }
        int case2 = dp1[1][n/3];
        
        return Math.max(case1, case2);
    }

    public int helperSO(int[] slices){
        int n = slices.length;
        
        int[] prev1 = new int[n + 2];
        int[] curr1 = new int[n + 2];
        int[] next1 = new int[n + 2];

        int[] prev2 = new int[n + 2];
        int[] curr2 = new int[n + 2];
        int[] next2 = new int[n + 2];

        for(int start = n - 2; start >= 0; start--){
            for(int slice = 1; slice <= n/3; slice++){
                int take = slices[start] + next1[slice - 1];
                int notTake = 0 + curr1[slice];
                prev1[slice] = Math.max(take, notTake);
            }
            next1 = curr1;
            curr1 = prev1.clone();
        }
        int case1 = curr1[n/3];

        for(int start = n - 1; start >= 1; start--){
            for(int slice = 1; slice <= n/3; slice++){
                int take = slices[start] + next2[slice - 1];
                int notTake = 0 + curr2[slice];
                prev2[slice] = Math.max(take, notTake);
            }
            next2 = curr2;
            curr2 = prev2.clone();
        }
        int case2 = curr2[n/3];
        
        return Math.max(case1, case2);
    }
}