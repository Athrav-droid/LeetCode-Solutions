class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        while(n!=0){
            if((n%2) != 0){
                ans*=x;
            }
            x*=x;
            n>>>=1;
        }
        // if(x==1){
        //     return 1;
        // }
        // if(n<0){
        //     for(int i=0;i<Math.abs(n);i++){
        //         ans*=(1/x);
        //     }
        //     return ans;
        // }
        // for(int i=0;i<n;i++){
        //     ans*=x;
        // }
        return ans;
    }
}