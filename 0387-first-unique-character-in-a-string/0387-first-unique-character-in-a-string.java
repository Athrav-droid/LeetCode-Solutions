class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> helper = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(helper.containsKey(c)){
                helper.put(c,helper.get(c) + 1);
            }else{
                helper.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(helper.get(c) == 1) return i;
        }
        return -1;
    }
}