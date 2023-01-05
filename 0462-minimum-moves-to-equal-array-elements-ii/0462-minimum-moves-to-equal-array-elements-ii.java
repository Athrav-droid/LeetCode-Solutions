class Solution {
    public int minMoves2(int[] nums) {
        //cronology:- Find the mid element and subtract every element from the mid element and add them up, you will find the solution and return it
        int sum = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n/2];
        for(int i=0;i<n;i++){
            sum = sum +(Math.abs(mid-nums[i]));
        }
        return sum;
    }
}