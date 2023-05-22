class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int key : freq.keySet()){
            ans.add(key);
        }
        Collections.sort(ans, (a,b) -> freq.get(b) - freq.get(a));
        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}