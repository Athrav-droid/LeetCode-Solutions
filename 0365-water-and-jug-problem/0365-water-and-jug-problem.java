class Solution {
    // if greatest common divisor ( gcd ) of two capacity is divisible to target Capacity then can obtain the target capacity else not.
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity == 0) return true;
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}