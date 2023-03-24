class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int hill = 0;
        int valley = 0;
        for(int i = 1; i < n - 1; i++){
            if(nums[i] == nums[i-1]) continue;
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && nums[i] == nums[left]) left--;
            while(right < n && nums[i] == nums[right]) right++;
            if(left == -1 || right == n) continue;
            if(nums[i] < nums[left] && nums[i] < nums[right]) valley++;
            if(nums[i] > nums[left] && nums[i] > nums[right]) hill++;
        }
        return valley + hill;
    }
}