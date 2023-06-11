class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1; 
        int right = maxSum;
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(getSum(index, mid, n) <= maxSum){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    private long getSum(int index, int value, int n){
        // index :- jis index ki value maximum krni h, value:- current max, n:- total Elements
        long count = 0;
        //left side
        if(value > index){
            count += (long)(value + value - index) * (index + 1) / 2;
        }else{
            count += (long)(value + 1) * value / 2 + index - value + 1;
        }
        //Right Side
        if(value >= n - index){
            count += (long)(value + value - n + 1 + index) * (n - index) / 2;
        }else{
            count += (long)(value + 1) * value / 2 + n - index - value;
        }
        // since value is added two times in both left and right side
        return count - value;
    }
}