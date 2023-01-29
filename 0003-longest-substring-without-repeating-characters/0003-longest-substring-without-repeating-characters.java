class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int l = s.length();
        // int ans = 0;
        // for(int i=0;i<l;i++){
        //     if(ans > l-i) break;
        //     Set<Character> helper = new HashSet<>();
        //     int count = 0;
        //     for(int j=i;j<l;j++){
        //         if(helper.contains(s.charAt(j))) break;
        //         helper.add(s.charAt(j));
        //         count++;
        //     }
        //     ans = Math.max(ans,count);
        // }
        // return ans;

        //SLIDING WINDOW APPROACH  
        Map<Character,Integer> helper = new HashMap<>();
        int i=0,j=0,max=0;
        while(j<s.length()){
            helper.put(s.charAt(j),helper.getOrDefault(s.charAt(j),0) + 1);
            if(helper.size() == j - i + 1){
                max = Math.max(max,j-i+1);
                j++;
            }else if(helper.size() < j - i + 1){
                while(helper.size() < j - i + 1){
                    helper.put(s.charAt(i),helper.get(s.charAt(i)) - 1);
                    if(helper.get(s.charAt(i)) == 0) helper.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}