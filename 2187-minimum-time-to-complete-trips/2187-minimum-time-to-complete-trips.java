class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for(int i : time){
            maxTime = Math.max(i, maxTime);
        }
        long left = 1;
        long right = (long) maxTime * totalTrips;
        while(left < right){
            long mid = left + (right - left)/2;
            if(helper(time, totalTrips, mid)) right = mid;
            else left = mid + 1; // agr left = mid krenge to TLE aayega 
        }
        return left;
    }
    public boolean helper(int[] time, int totalTrips, long mid){
        long count = 0;
        for(int i : time){
            count += mid / i;
        }
        return count >= totalTrips;
    }
}