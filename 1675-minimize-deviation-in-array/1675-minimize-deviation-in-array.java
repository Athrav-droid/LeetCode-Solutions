class Solution {
    public int minimumDeviation(int[] nums) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // int ans = Integer.MAX_VALUE;
        // boolean last = false;
        // if(nums[0] % 2 == 1) nums[0] *= 2;
        // if(nums[n-1] % 2 == 0){
        //     int x = nums[n-1];
        //     last = true;
        //     while(x % 2 == 0){
        //         x /= 2;
        //         nums[n-1] = x;
        //         Arrays.sort(nums);
        //         int diff = nums[n-1] - nums[0];
        //         ans = Math.min(ans,diff);
        //     }
        // }
        // return last ? ans : nums[n-1] - nums[0];

        //https://leetcode.com/problems/minimize-deviation-in-array/solutions/3223541/day-55-priority-queue-easiest-beginner-friendly-sol/
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1)
                num = num * 2;
            pq.offer(num);
            minVal = Math.min(minVal, num);
        }
        int minDeviation = Integer.MAX_VALUE;
        while (true) {
            int maxVal = pq.poll();
            minDeviation = Math.min(minDeviation, maxVal - minVal);
            if (maxVal % 2 == 1)
                break;
            maxVal = maxVal / 2;
            minVal = Math.min(minVal, maxVal);
            pq.offer(maxVal);
        }
        return minDeviation;
    }
}