class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, ans = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))) ans++;
        }
        int max = ans;
        for(int i = start; i < s.length() - k; i++){
            if(isVowel(s.charAt(i))) ans--;
            if(isVowel(s.charAt(i+k))) ans++;
            max = Math.max(ans, max);
        }
        return max;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else return false;
    }
}