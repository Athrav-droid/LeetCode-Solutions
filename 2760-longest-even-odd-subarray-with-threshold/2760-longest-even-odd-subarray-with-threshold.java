class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int max = 0;
        int ans = 0;
        boolean evenCheck = false;
        for(int i = 0; i < n; i++){
            if(isEven(nums[i]) && nums[i] <= threshold){
                boolean prev = true;
                evenCheck = true;
                ans++;
                for(int j = i + 1; j < n; j++){
                    if(prev && nums[j] <= threshold && !isEven(nums[j])){
                        ans++;
                        prev = false;
                        continue;
                    }
                    if(!prev && nums[j] <= threshold && isEven(nums[j])){
                        ans++;
                        prev = true;
                        continue;
                    }
                    break;
                }
                max = Math.max(max, ans);
                ans = 0;
            }
        }
        return evenCheck ? max : 0;
    }
    public boolean isEven(int n){
        return n % 2 == 0 ? true : false;
    }
}