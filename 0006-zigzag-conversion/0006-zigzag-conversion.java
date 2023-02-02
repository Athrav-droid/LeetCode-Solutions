class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows == s.length()) return s;
        StringBuilder ans = new StringBuilder();
        int jump = (numRows - 1) * 2;
        for(int i=0;i<numRows;i++){ 
            int j = i;
            while(j<s.length()){
                if(i == 0 ||i == numRows-1){
                    ans.append(s.charAt(j));
                    j+=jump;
                }else{
                    int smallJump = jump - (i * 2);
                    ans.append(s.charAt(j));
                    if(j+smallJump < s.length()){
                        ans.append(s.charAt(j+smallJump));
                    }
                    j+=jump;
                }
            }
        }
        return ans.toString();
    }
}