class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int count = 0;
        HashSet<Character> helper = new HashSet<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(helper.contains(c)){
                count+=2;
                helper.remove(c);
            }else{
                helper.add(c);
            }
        }
        if(helper.size() > 0) count++;
        return count;
    }
}