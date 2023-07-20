class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        int[] leftDis = new int[n];
        int[] rightDis = new int[n];
        
        Set<Integer> freq = new HashSet<>();

        for(int i = 0; i < n; i++){
            freq.add(nums[i]);
            leftDis[i] = freq.size();
        }
        freq.clear();
        for(int i = n - 1; i >= 0; i--){
            rightDis[i] = freq.size();
            freq.add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            ans[i] = leftDis[i] - rightDis[i];
        }
        return ans;
    }
}