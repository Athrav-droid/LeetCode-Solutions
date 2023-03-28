class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // return helper(days, costs, 0);

        // int[] dp = new int[days.length + 1];
        // return helperMem(days, costs, 0, dp);

        return helperTab(days, costs);
    }
    public int helperTab(int[] days, int[] costs){
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int k = n - 1; k >= 0; k--){
            int opt1 = costs[0] + dp[k + 1];

            int i;
            for(i = k; i < days.length && days[i] <= days[k] + 6; i++);
            int opt2 = costs[1] + dp[i];

            for(i = k; i < days.length && days[i] <= days[k] + 29; i++);
            int opt3 = costs[2] + dp[i];

            dp[k] = Math.min(opt1, Math.min(opt2, opt3));
        }
        return dp[0];
    }
    // public int helperMem(int[] days, int[] costs, int index, int[] dp){
    //     if(index >= days.length) return 0;

    //     if(dp[index] != 0) return dp[index];

    //     int opt1 = costs[0] + helperMem(days, costs, index + 1, dp);

    //     int i;
    //     for(i = index; i < days.length && days[i] <= days[index] + 6; i++);
    //     int opt2 = costs[1] + helperMem(days, costs, i, dp);

    //     for(i = index; i < days.length && days[i] <= days[index] + 29; i++);
    //     int opt3 = costs[2] + helperMem(days, costs, i, dp);

    //     return dp[index] = Math.min(opt1, Math.min(opt2, opt3));
    // }
    // public int helper(int[] days, int[] costs, int index){
    //     if(index >= days.length) return 0;

    //     int opt1 = costs[0] + helper(days, costs, index + 1);

    //     int i;
    //     for(i = index; i < days.length && days[i] <= days[index] + 6; i++);
    //     int opt2 = costs[1] + helper(days, costs, i);

    //     for(i = index; i < days.length && days[i] <= days[index] + 29; i++);
    //     int opt3 = costs[2] + helper(days, costs, i);

    //     return Math.min(opt1, Math.min(opt2, opt3));
    // }
}