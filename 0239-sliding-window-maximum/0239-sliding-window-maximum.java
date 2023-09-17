class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Optimal Approach
        int n = nums.length;
        int idx = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < n; i++){
			// Remove out of window indexes from the deque
            if(!q.isEmpty() && q.peek() <= i - k)  q.poll();
            // Removing all smaller elements
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();

            q.offer(i);
            if(i >= k - 1) ans[idx++] = nums[q.peek()];
		}
        return ans;


        // Brute Force
        // int[] ans = new int[n - k + 1];
		// for(int i = 0; i < ans.length; i++){
		// 	int max = Integer.MIN_VALUE;
		// 	for(int j = i; j < i + k; j++){
		// 		max = Math.max(arr[j], max);
		// 	}
		// 	ans[i] = max;
		// }
        // return ans;
    }
}