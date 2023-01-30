class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if(n==1) return "1";
        String ans = countAndSay(n-1);
        int count = 1;
        char curr = ans.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<ans.length();i++){ //just counting and appending using stringbuilder
            if(ans.charAt(i) == curr) count++;
            else{
                sb.append(count).append(curr);
                count = 1;
                curr = ans.charAt(i);
            }
        }
        if(count>0) sb.append(count).append(curr); //if n=2 ke liye check kre to for loop run nhi krega so ek bar check krna pdega ki count 1 h ky .. if so then we append count and num becoz single element jb string m ho tb program issue na re
        return sb.toString();
    }
}