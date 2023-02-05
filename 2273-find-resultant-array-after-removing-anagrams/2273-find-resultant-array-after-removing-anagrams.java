class Solution {
    public List<String> removeAnagrams(String[] words) {
        //APPROACH FOR EVERY ELEMENT IN WORDS ARRAY NOT FOR ADJACENT
        // Map<String, String> map = new HashMap<>();
        // List<String> ans = new ArrayList<>();
        // for(int i=0;i<words.length;i++){
        //     String curr = words[i];
        //     char[] currArr = curr.toCharArray();
        //     Arrays.sort(currArr);
        //     String newCurr = new String(currArr);
        //     if(!map.containsKey(newCurr)){
        //         map.put(newCurr,curr);
        //     }
        // }
        // for(int i=0;i<words.length;i++){
        //     String curr = words[i];
        //     char[] currArr = curr.toCharArray();
        //     Arrays.sort(currArr);
        //     String newCurr = new String(currArr);
        //     if(map.containsKey(newCurr) && map.get(newCurr).equals(curr) && !ans.contains(curr)) ans.add(curr);
        // }
        // return ans;

        //ADJACENT APPROACH
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int j=i+1;
            while(j<words.length && isAnagram(words[i],words[j])) j++;
            ans.add(words[i]);
            i=j-1;
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