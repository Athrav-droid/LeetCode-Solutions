class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        for(int i : banned) ban.add(i);
        int ans = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(!ban.contains(i)){
                if(sum + i <= maxSum){
                    ans++;
                    sum += i;
                }
            }
        }
        return ans;
    }
}