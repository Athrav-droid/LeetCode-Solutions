class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++){
            if(freq.containsKey(cards[i])){
                ans = Math.min(ans, i - freq.get(cards[i]) + 1);
            }
            freq.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}