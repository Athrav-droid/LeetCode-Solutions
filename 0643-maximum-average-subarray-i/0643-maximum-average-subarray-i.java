class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int j = k - 1;
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum += (double)nums[i];
        }
        int i = 0;
        double maxAvg = sum / k;
        while(++j < nums.length){
            sum = sum - (double)nums[i] + (double)nums[j];
            maxAvg = Math.max(sum/k, maxAvg);
            i++;
        }
        return maxAvg;
    }
}