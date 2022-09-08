class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        if(x<0){
            return false;
        }
        if(x<10 && x>-1){
            return true;
        }
        int rem =0;
        int sum=0;
        while(x>0){
            rem = x%10;
            sum = (sum*10)+rem;
            x=x/10;
        }
        if(y==sum){
            return true;
        }else{
            return false;
        }   
    }
}