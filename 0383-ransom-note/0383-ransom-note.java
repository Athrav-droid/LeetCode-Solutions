class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> helper = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            if(helper.containsKey(c)){
                helper.put(c,helper.get(c) + 1);
            }else{
                helper.put(c,1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!helper.containsKey(c)) return false;
            if(helper.containsKey(c)){
                if(helper.get(c) < 1) return false;
                else helper.put(c,helper.get(c) - 1);
            }else{
                return false;
            }
        }
        return true;
    }
}