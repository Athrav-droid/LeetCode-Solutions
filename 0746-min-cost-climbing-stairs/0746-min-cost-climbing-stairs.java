class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // //Approach using O(1) space complexity
        // int a = cost[0];
        // int b = cost[1];
        // for(int i=2;i<cost.length;i++){
        //     int curr = cost[i] + Math.min(a,b);
        //     a=b;
        //     b=curr;
        // }
        // return Math.min(a,b);
        return helper(cost,cost.length);

    }
    public int helper(int[] cost,int n){
        ArrayList<Integer> dp = new ArrayList<>(n+1);
        dp.add(cost[0]);
        dp.add(cost[1]);
        for(int i=2;i<cost.length;i++){
            dp.add(cost[i] + Math.min(dp.get(i-1),dp.get(i-2)));
        }
        return Math.min(dp.get(n-1),dp.get(n-2));
    }
}