class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return Math.min(k, numOnes) - Math.max(0, k - numOnes - numZeros);
        // if((numOnes + numZeros + numNegOnes) < k) return -1;
        // int ans = numOnes;
        // if(k <= numOnes) return k;
        // else{
        //     k -= numOnes;
        //     if(k <= numZeros) return ans;
        //     else{
        //         k -= numZeros;
        //         return ans - k;
        //     }
        // }
    }
}