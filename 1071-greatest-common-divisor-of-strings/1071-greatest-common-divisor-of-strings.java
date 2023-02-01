class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!((str1 + str2).equals(str2 + str1))) return "";
        int sub = helper(str1.length(),str2.length());
        return str1.substring(0,sub);
    }
    public int helper(int a, int b){
        if(b==0) return a;
        else return helper(b,a%b);
    }
}