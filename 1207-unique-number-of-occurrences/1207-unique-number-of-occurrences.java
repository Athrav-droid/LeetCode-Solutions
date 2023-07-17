class Solution {
    int offset = 1000;
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        for(int a : arr){
            freq[a + offset]++;
        }
        Set<Integer> check = new HashSet<>();
        for(int i = 0; i < 2001; i++){
            if(freq[i] == 0) continue;
            if(check.contains(freq[i])) return false;
            check.add(freq[i]);
        }
        return true;
    }
}