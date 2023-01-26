class Solution {
    public char repeatedCharacter(String s) {
        Map<Character,Integer> helper = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(helper.containsKey(c)){
                return c;
            }else{
                helper.put(c,1);
            }
        }
        return s.charAt(0);
    }
}