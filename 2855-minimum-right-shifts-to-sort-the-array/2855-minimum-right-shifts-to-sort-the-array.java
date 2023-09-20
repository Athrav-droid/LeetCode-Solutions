class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        // LINEAR SEARCH
        int shifts = 0, n = nums.size(), idx = 0;
        for(int i = 1; i < n; i++){
            if(nums.get(i) < nums.get(i - 1)) {
                shifts++;
                idx = i;
            }
        }
        if(shifts > 1) return -1;
        if(nums.get(0) < nums.get(n - 1) && shifts != 0) return -1;
        return (n - idx) % n;
        // NOT WORKING BS
        // int n = nums.size();
        // int left = nums.get(0), right = nums.get(n - 1);
        // int low = 0, high = n - 1;
        // while(low <= high){
        //     int mid = low + (high - low) / 2;
        //     int m = nums.get(mid);
        //     if(mid == 0 || mid == n - 1) {
        //         for(int i = 0; i < n - 1; i++){
        //             if(nums.get(i) > nums.get(i + 1)) return -1;
        //         }
        //         return 0;
        //     }
        //     else if(m <= nums.get(mid - 1) && m <= nums.get(mid + 1) && left >= right) return n - mid;
        //     if(m > left) low = mid + 1;
        //     else high = mid - 1;

        // } 
        // return -1;
    }
}