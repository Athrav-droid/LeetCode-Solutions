class Solution {
    public int maxProduct(int[] nums) {
        // if(nums.length == 1) return nums[0];
        // int max = 0;
        // for(int i=0;i<nums.length-1;i++){
        //     int k = i;
        //     int mul = nums[k];
        //     for(int j = i+1;j<nums.length;j++){
        //         mul *= nums[j];
        //         max = Math.max(max, mul);
        //     }
        // }
        // return max;
        if(nums.length == 1) return nums[0];
        int max = nums[0], min = nums[0], ans = nums[0];
        for(int i=1;i<nums.length;i++){
            System.out.println(max);
            System.out.println(min);
            System.out.println("----");
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            } // swapping when negative coz it -ve number will convert max into min and min to max for that particular loop 
            System.out.println(max);
            System.out.println(min);
            System.out.println("----");
            
            max = Math.max(nums[i], max * nums[i]); // two possiblities 1. you are starting a new subarray i.e nums[i] 2. continuing the old array i.e nums[i] * max
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}