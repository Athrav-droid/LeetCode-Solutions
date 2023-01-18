class Solution {
    //O(logn) Binary Search 
    public int arrangeCoins(int n) {
        if(n==1) return 1;
        long low = 0;
        long high = n;
        while(low<=high){
            long mid = low + (high - low)/2;
            long formula = mid * (mid + 1)/2;
            if(n == formula) return (int)mid;
            else if(n > formula) low = mid + 1;
            else high = mid -1;
        }
        return (int)low - 1;
    }
}