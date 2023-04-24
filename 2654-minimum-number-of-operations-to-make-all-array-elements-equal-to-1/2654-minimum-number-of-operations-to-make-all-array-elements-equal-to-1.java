class Solution {
    public int minOperations(int[] nums) {
        //NOTE:- gcd of 1 and any other number is always one.
        int ones = 0, result = Integer.MAX_VALUE;
        // if one already exists in array then count the number of ones in array and return nums.length - ones to find minimum operations
        for(int a : nums) if(a == 1) ones++;
        if(ones > 0) return nums.length - ones;
        // for every element check which element pair will give gcd one or which subarray will give minimum steps to make gcd 1. 
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                curr = gcd(curr, nums[j]);
                if(curr == 1){
                    result = Math.min(result, j - i);
                }
            }
        }
        // if no one makes gcd 1 then return -1 else return result + no. of steps to make others element 1.
        return result == Integer.MAX_VALUE ? -1 : result + nums.length - 1;
    }
    public int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}