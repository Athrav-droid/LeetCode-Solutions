class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        int left = 0;
        int right = n;
        int total = (n * (n + 1))/2;
        while(left < right){
            int mid = left + (right - left)/2;
            int pre = (mid * (mid + 1))/2;
            int pos = total - pre + mid;
            if(pre == pos) return mid;
            else if(pre < pos) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}