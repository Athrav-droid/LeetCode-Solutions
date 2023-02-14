class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int initial = carry;
            if(i >= 0){
                initial += a.charAt(i) - '0';
            }
            if(j >= 0){
                initial += b.charAt(j) - '0';
            }
            carry = initial > 1 ? 1 : 0;
            ans.append(initial % 2);
            i--;j--;
        }
        if(carry != 0) ans.append(carry);
        return ans.reverse().toString();

        //MY APPROACH GIVING WRONG ANS
        // int aL = a.length();
        // int bL = b.length();
        // boolean carry = false;
        // StringBuilder sb = new StringBuilder();
        // while(aL > 0 && bL > 0){
        //     if(!carry){
        //         if(a.charAt(aL - 1) == '0' && b.charAt(bL - 1) == '0') sb.append(a.charAt(aL - 1));
        //         else if((a.charAt(aL - 1) == '1' && b.charAt(bL - 1) == '0') || (a.charAt(aL - 1) == '0' && b.charAt(bL - 1) == '1') ) sb.append("1");
        //         else{
        //         sb.append(a.charAt(aL - 1));
        //         carry = true;
        //         }
        //     }else{
        //         if(a.charAt(aL - 1) == '0' && b.charAt(bL - 1) == '0'){
        //             sb.append("1");
        //             carry = false;
        //         }
        //         else if((a.charAt(aL - 1) == '1' && b.charAt(bL - 1) == '0') || (a.charAt(aL - 1) == '0' && b.charAt(bL - 1) == '1') ) sb.append("0");
        //         else sb.append("1");
        //     }
        //     aL--;bL--;
        // }
        // while(aL > 0){
        //     if(carry){
        //         if(a.charAt(aL - 1) == '0'){
        //             sb.append("1");
        //             carry = false;
        //         }else sb.append("0");
        //     }else{
        //         if(a.charAt(aL - 1) == '0'){
        //             sb.append("0");
        //         }else sb.append("1");
        //     }
        //     aL--;
        // }
        // while(bL > 0){
        //     if(carry){
        //         if(a.charAt(bL - 1) == '0'){
        //             sb.append("1");
        //             carry = false;
        //         }else sb.append("0");
        //     }else{
        //         if(a.charAt(bL - 1) == '0'){
        //             sb.append("0");
        //         }else sb.append("1");
        //     }
        //     bL--;
        // }
        // return sb.reverse().toString();
    }
}