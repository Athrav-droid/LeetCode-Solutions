class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length > h) return -1;
        long left = 1;
        long right = 0;
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile, max);
        }
        right = (long) max;
        if(piles.length == h) return max;
        while(left < right){
            long mid = left + (right - left)/2;
            if(helper(piles, h, mid)) right = mid;
            else left = mid + 1;
        }
        return (int) left;
    }
    public boolean helper(int[] piles, int h, long mid){
        int count = 0;
        for(int pile : piles){
            count += (int) Math.ceil((double) pile / (double) mid);
        }
        return count <= h;
    }
}