class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int n : nums){
            ans.add(n);
            freq.put(n, freq.getOrDefault(n, 1) + 1);
        }
        Collections.sort(ans, (a, b) -> (freq.get(a) == freq.get(b)) ? b - a : freq.get(a) - freq.get(b));
        return ans.stream().mapToInt(i -> i).toArray();
    }
}