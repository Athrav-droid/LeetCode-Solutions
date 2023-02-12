class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        //BRUTE FORCE SHOWING TLE
        // int ans = 0;
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         int a = nums[i] + nums[j];
        //         if(i >= 0 && i < j && j > i && j < n){
        //             if(a >= lower && a <= upper){
        //                 ans++;
        //             }
        //         }
        //     }
        // }
        // return ans;
        
        //BINARY SEARCH APPROACH
        Arrays.sort(nums);
        long ans = 0;
        for(int i=0;i<nums.length-1;i++){
            int left = searchLeft(lower - nums[i], i+1, nums);
            int right = searchRight(upper - nums[i], i+1, nums);

            if(left == -1 || right == -1) continue;
            // System.out.println(right);
            // System.out.println(left);
            // System.out.println("values");
            // System.out.println(nums[right]);
            // System.out.println(nums[left]);
            // System.out.println("next");
            ans += (right - left + 1);
        }
        return ans;
    }
    
    public int searchLeft(int target, int start, int[] nums){
        int left = start, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) right = mid;
            else left = mid;
        }
        if(nums[left] >= target) return left;
        if(nums[right] >= target) return right;
        return -1;
    }

    public int searchRight(int target, int start, int[] nums){
        int left = start, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target) right = mid;
            else left = mid;
        }
        if(nums[right] <= target) return right;
        if(nums[left] <= target) return left;      
        return -1;
    }
}