public class Solution {
    // you need to treat n as an unsigned value

    //https://leetcode.com/problems/number-of-1-bits/solutions/1519675/java-c-simple-optimised-faster-than-100-detailed-explanation/?envType=study-plan&id=algorithm-i&languageTags=java

    //number n ko use just 1 less wale number se agr and krenge to jo rightmost set bit hogi vo off(0) ho jayegi .. so loop sirf utni bar run krega jitni number m 1 honge.
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            ++count;
            n &= (n-1);
        }
        return count;
    }
}