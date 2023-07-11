class Solution {
    // Recursive Approach:- Take the current Element or not Take the current element, if taking then update the sum, 
    // update the minimum so far, increase the index, and increase the count or decrease k as per your wish.

    // Sort array in decreasing order after pairing them, then consider each element as minimum from nums2 (you may 
    // skip k - 1 elements because if there are not k - 1 elements then minimum will be changed or we cannot make window 
    // of k elements), then calculate sum of k elements and update the answer, before updating the answer keep track of the minimum element from nums1 which can be removed when moving to next index and adding other element (using priority queue)
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
            int n = nums1.length;

            // to Pair nums1 and nums2 we can't change the pairs so
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; ++i) {
                pairs[i] = new int[]{nums1[i], nums2[i]};
            }
            
            Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Use a min-heap to maintain the top k elements.
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>();
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        
        // The score of the first k pairs.
        long answer = topKSum * pairs[k - 1][1];
        
        // Iterate over every nums2[i] as minimum from nums2.
        for (int i = k; i < n; ++i) {
            // Remove the smallest integer from the previous top k elements
            // then ddd nums1[i] to the top k elements.
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            
            // Update answer as the maximum score.
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        
        return answer;
    }
}