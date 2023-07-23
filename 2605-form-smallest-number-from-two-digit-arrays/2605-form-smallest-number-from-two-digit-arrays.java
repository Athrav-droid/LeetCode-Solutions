class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> freq = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i : nums1) freq.add(i);
        for(int i : nums2) if(freq.contains(i)) return i;
        int ans = nums1[0];
        if(nums1[0] != nums2[0]){
            if(nums1[0] < nums2[0]){
                ans *= 10;
                ans += nums2[0];
            }else{
                ans += nums2[0] * 10;
            }
        }
        return ans;
    }
}