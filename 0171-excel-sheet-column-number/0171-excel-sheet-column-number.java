class Solution {
    //65(A) - 90(Z)
    public int titleToNumber(String s) {
        if(s.length() == 1) return s.charAt(0) - 64;
        int j=0;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){
            int c = s.charAt(i) - 64;
            ans += c*Math.pow(26,j);
            j++;
        }
        return ans;
    }
}