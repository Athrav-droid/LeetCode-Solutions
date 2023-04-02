class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(freq.containsKey(nums[i]) && Math.abs(freq.get(nums[i]) - i) <= k) return true;
            freq.put(nums[i], i);
        }
        return false;
    }
}