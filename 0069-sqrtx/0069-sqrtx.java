class Solution {
    public int mySqrt(int x) {
        // return (int)(Math.sqrt(x));
        long low = 1;
        long high = x;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid * mid <= x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return (int)(ans);
    }
}