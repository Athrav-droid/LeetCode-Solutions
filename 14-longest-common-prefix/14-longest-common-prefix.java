class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder ans = new StringBuilder("");
        // for(int i=0;i<strs.length-1;i++){
        //     if(strs[i].charAt(i) == strs[i+1].charAt(i)){
        //         ans.append(strs[i].charAt(i));
        //     }
        // }
        // return ans.toString();
        
        String ans = "";
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        for(int i=0;i<(start.length());i++){
            if(start.charAt(i) == end.charAt(i)){
                ans += start.charAt(i);
            }else{
                break;
            }
        }
        return ans;
    }
}