class Solution {
    public String reverseWords(String s) {
        // String[] ques = s.split(" ");
        // String ans = " ";
        // for(int i=0;i<ques.length;i++){
        //     char[] mini = ques[i].toCharArray();
        //     String rev = " ";
        //     for(int j=0;j<ques[i].length();j++){
        //         rev = ques[i].charAt(j) + rev ;
        //     }
        //     ans += rev;
        // }
        // return ans.trim();
        String[] ques = s.split(" ");
        String ans = " ";
        for(int i=0;i<ques.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(ques[i]);
            sb.reverse();
            if(i != ques.length -1) ans = ans + sb.toString() + " ";
            else ans += sb.toString();
        }
        return ans.trim();
    }
}
