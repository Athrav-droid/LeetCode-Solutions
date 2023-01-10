class Solution {
    //Algorithm used :- Sieve of Eratosthenes
    public int countPrimes(int n) {
        int count = 0;
        boolean[] helper = new boolean[n];
        Arrays.fill(helper, true);
        for(int i=2;i*i<n;i++){
            if(helper[i]){
                // count++;
                for(int j=i+i;j<n;j+=i){
                    helper[j] = false;
                }
            }
        } 
        for(int i=2;i<n;i++){
            if(helper[i]) count++;
        }
        return count;
    }
}