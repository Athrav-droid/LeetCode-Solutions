class Solution {
    //Tabulation method using DP, Love Babber lec 105
    //since first and last house be adjacent so we will have two conditions:- 1. we will rob house 1 and left the last one 2. we will rob last house and left the first one
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)),helper(Arrays.copyOfRange(nums, 1, n)));
    }

    public int helper(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int first = 0; //initial value is 0, not referring to any house for now
        int second = nums[0]; // initial value will be first value of array representing first house money
        int ans = 0; // will store ans in these variable
        for(int i=1;i<nums.length;i++){ // loop from house no. 1 because 0th house is already included in second variable
            int inc = first + nums[i]; // if we are including any house then we will add its money // starting from house 2
            int exc = second + 0; // if excluding any house then we will add 0 // starting for house 1
            ans = Math.max(inc,exc); // finding the max element among both and add max element to ans
            first = second; // moving ahead in our array;
            second = ans;
        }
        return ans;
    }
}