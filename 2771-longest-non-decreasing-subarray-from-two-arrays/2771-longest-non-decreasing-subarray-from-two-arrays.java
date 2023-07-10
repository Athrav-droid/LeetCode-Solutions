class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if(n == 1) return 1;
        int ans = 1, prev1 = 1, prev2 = 1;
        int dp11 = 0, dp12 = 0, dp21 = 0, dp22 = 0; 
        
        for(int i = 1; i < n; i++){
            // if value is greater that means we can continue the subarray and if not that means we are starting a 
            // new sub array so 1 is assigned.
            dp11 = nums1[i - 1] <= nums1[i] ? prev1 + 1 : 1;
            dp12 = nums1[i - 1] <= nums2[i] ? prev1 + 1 : 1;
            dp21 = nums2[i - 1] <= nums1[i] ? prev2 + 1 : 1;
            dp22 = nums2[i - 1] <= nums2[i] ? prev2 + 1 : 1;

            prev1 = Math.max(dp11, dp21);
            prev2 = Math.max(dp12, dp22);
            ans = Math.max(ans, Math.max(prev1, prev2));
        }
        
        return ans;
    }
}