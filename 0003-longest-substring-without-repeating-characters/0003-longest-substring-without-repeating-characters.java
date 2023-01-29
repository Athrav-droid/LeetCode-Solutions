class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int ans = 0;
        for(int i=0;i<l;i++){
            if(ans > l-i) break;
            Set<Character> helper = new HashSet<>();
            int count = 0;
            for(int j=i;j<l;j++){
                if(helper.contains(s.charAt(j))) break;
                helper.add(s.charAt(j));
                count++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}