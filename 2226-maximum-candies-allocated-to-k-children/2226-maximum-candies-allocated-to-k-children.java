class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 1;
        long right = 0;
        long sum = 0;
        for(int candy : candies){
            sum += (long) candy;
            right = Math.max(right, candy);
        }
        if(sum < k) return 0;
        while(left <= right){
            long mid = left + (right - left)/2;
            if(helper(candies, k, mid)){
                left = mid + 1;
                sum = (int)mid;
            }
            else right = mid - 1;
        }
        return (int) sum;
    }
    public boolean helper(int[] candies, long k, long mid){
        long count = 0;
        for(int candy : candies){
            count += candy / mid;
        }
        return count >= k;
    }
}