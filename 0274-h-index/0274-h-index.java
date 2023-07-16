class Solution {
    // citations means quality and index of array means quantity, x quality is h index if there are more than x papers
    // with atleast x quality.
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        for(int num : citations){
            if(num > n) freq[n]++;
            else{
                freq[num]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += freq[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}