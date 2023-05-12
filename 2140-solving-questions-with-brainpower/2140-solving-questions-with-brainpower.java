class Solution {
    public long mostPoints(int[][] questions) {
        // return helperRec(questions, 0);

        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);
        return helperMem(questions, 0, dp);
    }
    public long helperRec(int[][] questions, int index){
        if(index > questions.length - 1) return 0;
        long points = 0;
        long take = (long)questions[index][0] + helperRec(questions, index + questions[index][1] + 1);
        long notTake = 0 + helperRec(questions, index + 1);
        return Math.max(take, notTake);
    }

    public long helperMem(int[][] questions, int index, long[] dp){
        if(index > questions.length - 1) return 0;
        if(dp[index] != -1) return dp[index];
        long points = 0;
        long take = (long)questions[index][0] + helperMem(questions, index + questions[index][1] + 1, dp);
        long notTake = 0 + helperMem(questions, index + 1, dp);
        return dp[index] = Math.max(take, notTake);
    }
}