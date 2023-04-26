class Solution {
    public int addDigits(int num) {
        while(num>9){
            num = sum(num);
        }
        return num;
    }
    public int sum(int num){
        int rem = 0;
        int ans = 0;
        while(num>0){
            rem = num%10;
            ans = ans + rem;
            num=num/10;
        }
        return ans;
    }
}