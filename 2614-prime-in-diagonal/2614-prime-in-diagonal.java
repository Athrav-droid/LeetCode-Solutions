class Solution {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(isPrime(nums[i][i])) ans = Math.max(ans, nums[i][i]);
            if(isPrime(nums[i][nums.length - 1 - i])) ans = Math.max(ans, nums[i][nums.length - 1 - i]);
        }
        return ans;
    }
    public boolean isPrime (int n){
        if(n == 1) return false;
        if(n == 2 || n == 3 || n == 5) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}