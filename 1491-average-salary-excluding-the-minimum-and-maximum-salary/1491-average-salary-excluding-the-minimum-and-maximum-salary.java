class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = salary.length - 2;
        double ans = 0;
        for(int num : salary){
            min = Math.min(min, num);
            max = Math.max(max, num);
            ans += num;
        }
        return (ans - min - max) / n;
    }
}