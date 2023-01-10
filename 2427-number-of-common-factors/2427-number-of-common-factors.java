class Solution {
    public int commonFactors(int a, int b) {
        int count = 1;
        int c = Math.min(a,b);
        int d = Math.max(a,b);
        for(int i=2;i<=c;i++){
            if((c%i)==0 && (d%i)==0) count++;
        }
        return count;
    }
}