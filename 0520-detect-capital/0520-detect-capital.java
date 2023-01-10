class Solution {
    public boolean detectCapitalUse(String word) {
        HashMap<String,Integer> helper = new HashMap<>();
        helper.put("upper",0);
        helper.put("lower",0);
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) >=97 && word.charAt(i) <=122){
                helper.put("lower",helper.get("lower")+1);
            }else{
                helper.put("upper",helper.get("upper")+1);
            }
        }
        int n = word.length();
        if(helper.get("upper") == n) return true;
        if(helper.get("lower") == n) return true;
        if(word.charAt(0) >=65 && word.charAt(0) <=90 && helper.get("lower") == (n-1)) return true;
        return false;
    }
}