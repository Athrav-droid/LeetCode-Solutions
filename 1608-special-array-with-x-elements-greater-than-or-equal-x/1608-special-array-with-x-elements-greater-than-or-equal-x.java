class Solution {
    public int specialArray(int[] nums) {
        int low = 0;
        int high = nums.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] >= mid) count++;
            }
            if(count == mid) return mid;
            if(count > mid) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}