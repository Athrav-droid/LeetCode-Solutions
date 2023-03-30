//https://leetcode.com/problems/scramble-string/solutions/3357439/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/
// We can also use another Approach of counting the frequency.
class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        
        // if length not equal return false
        if(s2.length() != n) return false;
        
        // if strings are equal then return true;
        if(s1.equals(s2)) return true;
        
        // if after both previous check , now length is 1 then we can return false . CASE:- 'a' and 'b'
        if(n == 1) return false;
        
        //Generating a Unique Key for every String
        String key = s1 + "*" + s2;
        
        // if already these call is acheived before than return the stored ans
        if(map.containsKey(key)) return map.get(key);
        
        //checking for each subpart
        for(int i = 1; i < n; i++){
            // for NOT SWAP Condition
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                map.put(key, true);
                return true;
            }
            // for SWAP Condition
            if(isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i))){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}