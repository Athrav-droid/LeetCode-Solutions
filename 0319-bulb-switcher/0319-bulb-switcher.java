class Solution {
    public int bulbSwitch(int n) {
        if(n <= 1) return n;
        return (int)Math.sqrt(n);
    }
}