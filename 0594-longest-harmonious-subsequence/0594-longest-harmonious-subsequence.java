class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if(freq.containsKey(i + 1)){
                ans = Math.max(ans, freq.get(i) + freq.get(i + 1));
            }
            if(freq.containsKey(i - 1)){
                ans = Math.max(ans, freq.get(i) + freq.get(i - 1));
            }
        }
        return ans;
    }
}