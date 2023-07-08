class Solution {
    public long putMarbles(int[] weights, int k) {
        // Approach:- We will create a Pair Sum Array in which we will keep values of pair and their sum, since if we are splitting array from a point (i) then its pair sum will be i, i+1 or i, i-1 based on our understanding.
        // we are neglecting the first and last values as they are common in every pair 
        // We will sort the pair sum and calculate our result by taking k - 1 elements for both min and max
        int n = weights.length;
        long[] pairSum = new long[n - 1];
        for(int i = 0; i < n - 1; i++){
            pairSum[i] = (long)weights[i] + (long)weights[i + 1];
        }
        Arrays.sort(pairSum);
        long min = 0; 
        long max = 0;
        for(int i = 0; i < k - 1; i++){
            min += pairSum[i];
            max += pairSum[n - 2 - i];
        }
        return max - min;
    }
}