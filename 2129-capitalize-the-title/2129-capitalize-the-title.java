class Solution {
    public String capitalizeTitle(String title) {
        String[] helper = title.split(" ");
        String ans = "";
        for(String s : helper){
            if(s.length() == 1 || s.length() == 2){
                ans += s.toLowerCase() + " ";
            }else{
                ans += s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase() + " ";
            }
        }
        return ans.trim();
    }
}