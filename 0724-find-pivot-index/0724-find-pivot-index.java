class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = nums[0];
        rightSum[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            leftSum[i] = leftSum[i - 1] + nums[i];
        }
        for(int i = n - 2; i >= 0; i--){
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        if(n > 1) if(rightSum[1] == 0) return 0; 
        for(int i = 1; i < n - 1; i++){
            if(leftSum[i - 1] == rightSum[i + 1]) return i;
        }
        if((n - 2) > 0) if(leftSum[n - 2] == 0) return n - 1;
        return -1;
    }
}