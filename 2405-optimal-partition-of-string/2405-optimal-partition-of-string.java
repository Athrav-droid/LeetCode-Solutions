class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        int count = 1; // to substring possibles till now
        int currStart = 0; // will store the start index of the current sub String
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] >= currStart){ // it shows the the particular char has already appeared in the curr SubString so increase the count and start a new substring.
                count++;
                currStart = i;
            }
            freq[s.charAt(i) - 'a'] = i; // at least update the last known place of the curr char in freq.
        }
        return count;
    }
}