class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,0,0,ans,"");
        return ans;
    }
    public void helper(int n,int left, int right, List<String> ans, String s) {
        if(s.length() == n*2){ //means we reached one of the string , becoz it must be of lenght 2n as their are opening and closing braces both;
            ans.add(s);
            return;
        }
        if(left<n) helper(n,left+1,right,ans,s+"("); // if left is less than n recusively call for next and add opening parenthesis coz u must first open the parethesis before closing it else it is not the valid output
        if(right<left) helper(n,left,right+1,ans,s+")"); // right is less than left coz open the braces first before closing
    }
}