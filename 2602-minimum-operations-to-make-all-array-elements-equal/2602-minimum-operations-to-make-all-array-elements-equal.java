class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        //BRUTE FORCE - TLE
        // List<Long> ans = new ArrayList<>();
        // for(int query : queries){
        //     long sum = 0;
        //     for(int num : nums){
        //         sum +=Math.abs(num - query);
        //     }
        //     ans.add(sum);
        // }
        // return ans;

        // PREFIX SUM + BINARY SEARCH
        Arrays.sort(nums);
        List<Long> ans = new ArrayList<>();
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for(int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for(int query : queries){
            int pivot = Arrays.binarySearch(nums, query);
            if(pivot < 0) pivot = Math.abs(pivot) - 1;
            // Total = query[i] * i - prefix[i] + prefix[n] - prefix[i] - query[i] * (n - i) // i is pivot
            ans.add(1L * query * (2 * pivot - n) + prefix[n] - 2 * prefix[pivot]);
        }
        return ans;
    }
}