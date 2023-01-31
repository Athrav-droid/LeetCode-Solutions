class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] check = new boolean[strs.length];
        for(int i=0;i<check.length;i++){
            check[i] = false;
        }
        for(int i=0;i<strs.length;i++){
            String curr = strs[i];
            List<String> helper = new ArrayList<>();
            if(check[i]) continue;
            for(int j=i;j<strs.length;j++){
                // if(check[j]) break;
                if(isAnagram(curr,strs[j])){
                    check[j] = true;
                    helper.add(strs[j]);
                }
            }
            ans.add(helper);
        }
        return ans;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int val: arr){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}