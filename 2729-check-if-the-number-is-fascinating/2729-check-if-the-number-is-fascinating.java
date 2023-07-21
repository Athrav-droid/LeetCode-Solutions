class Solution {
    public boolean isFascinating(int n) {
        int[] freq = new int[10];
        
        for(int i = 1; i <= 3; i++){
            int m = n * i;
            helper(m, freq);
        }
        for(int j = 1; j < 10; j++){
            if(freq[j] != 1) return false;
        }
        return true;
    }
    public void helper(int m, int[] freq){
        while(m > 0){
            int temp = m % 10;
            freq[temp]++;
            m = m / 10;
        }
    }
}