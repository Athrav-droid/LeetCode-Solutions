class Solution {
    public int integerReplacement(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(n >= Integer.MAX_VALUE) return 32;
        if(n == 1) return 0;
        if(n < 3) return 1;
        if(n < 5) return 2;
        if(n % 2 == 0) return 1 + helper(n/2);
        else return Math.min(1 + helper(n + 1), 1 + helper(n - 1));
    }
}