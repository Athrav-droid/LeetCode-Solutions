class Solution {
    public int bitwiseComplement(int n) {
        // edge Case 
        if(n == 0) return 1;

        // ~n or can be said as NOT of n reverses all the bits of the number
        // we will write shift until our no. is not equal to zero so that we can find how many bits have our answer
        // to create mask so that all the 0 bits in left side which got 1 when we NOT them, must be done 0 again 
        // and if we know how many bits have our answer than remaining bits can be AND with 0
        // Example:- 5 :- (representing in 16 bit) 0000000000000101
        // mask:- 3 digits, how to calculate:- use right shift until number is zero like
        // 0000000000000010 >> 1
        // 0000000000000001 >> 1
        // 0000000000000000

        // so to make our final answer starting bit as zero we need
        // mask right most 3 bits to be 1 and remaining zero
        // 000000000000000 << 1 OR 1
        // 000000000000001 << 1 OR 1
        // 000000000000011 << 1 OR 1
        // 000000000000111, 3 time because we calculated masked digit to be 3 
        
        // and in last do AND with mask;

        int m = n;
        int mask = 0;

        while(m != 0){
            mask = (mask << 1) | 1; // calculating mask 
            m = m >> 1; 
        }
        int ans = ~n & mask;
        return ans;
    }
}