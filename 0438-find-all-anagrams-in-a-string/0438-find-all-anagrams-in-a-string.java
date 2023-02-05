class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Map<Character, Integer> freq = new HashMap<>();
        List<Integer> anshelp = new ArrayList<>();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);
        int i=0;
        for(int j=sortedP.length()-1;j<s.length();j++){
            String curr = s.substring(i,j+1);
            char[] currArr = curr.toCharArray();
            Arrays.sort(currArr);
            String sortedCurr = new String(currArr);
            if(sortedP.equals(sortedCurr)){
                anshelp.add(i);
            }
            i++;
        }
        return anshelp;
    }
}