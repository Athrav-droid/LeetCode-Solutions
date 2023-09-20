class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // to keep values in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frequencyMap.values());
        while(maxHeap.size() > 1){
            int first_max = maxHeap.poll();
            int second_max = maxHeap.poll();
            first_max--;second_max--;
            if(first_max != 0) maxHeap.offer(first_max);
            if(second_max != 0) maxHeap.offer(second_max);
        }
        int sum = 0;
        while(maxHeap.size() > 0){
            sum += maxHeap.poll();
        }
        return sum;
    }
}