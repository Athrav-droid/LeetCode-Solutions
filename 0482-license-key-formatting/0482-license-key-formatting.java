class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int length = s.length()-1;
        int count =0;
        while(length >= 0){
            char c = s.charAt(length);
            if((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')){
                sb.append(c);
                count++;
                if(count % k == 0) sb.append('-');
            }
            length--;
        }
        if(count==0) return "";
        int n = sb.length()-1;
        if(sb.charAt(n) == '-'){
            StringBuilder ans = new StringBuilder(sb.substring(0,n));
            return ans.reverse().toString();
        }
        return sb.reverse().toString();
    }
}