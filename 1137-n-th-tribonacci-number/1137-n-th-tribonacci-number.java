class Solution {
    public int tribonacci(int n) {
        if(n==0||n==1) return n;
        if(n==2) return 1;
        int first = 0;
        int second = 1;
        int third = 1;
        int tribo = 0;
        for(int i=3;i<=n;i++){
            tribo = first + second + third;
            first = second;
            second = third;
            third = tribo;
        }
        return tribo;
    }
}