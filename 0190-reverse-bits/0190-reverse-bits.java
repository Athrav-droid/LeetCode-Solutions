public class Solution {
    // you need treat n as an unsigned value

    //For IN-PLACE TRAVERAL EXPLAINAION:- 
    //https://leetcode.com/problems/reverse-bits/solutions/1232842/java-c-0ms-o-1-time-complexity-in-place-detailed-explanation/?languageTags=java

    //For EXTRA SPACE for ans
    // https://leetcode.com/problems/reverse-bits/solutions/2680791/handwritten-solution/
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int lsb = n & 1; // find the least significant bit
            int temp = lsb << (31 - i); // take that bit and move to the right most valid position based on loop
            ans |= temp; // OR the ans with temp to adapt the changes in ans from temp, which can be returned
            n >>= 1; // right shift the number by 1 to get the lsb again
        }
        return ans;
    }
}