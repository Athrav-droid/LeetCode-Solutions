class Solution {
    public int findMin(int[] nums) {
        // Arrays.sort(nums);
        // return nums[0];

        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     set.add(nums[i]);
        // }
        // return Collections.min(set);

        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[right] == nums[mid]){
                if(nums[left] == nums[right]){
                    left++;
                    right--;
                }
                else if(nums[left] < nums[right]) right--;
                else left++;
            }else if(nums[mid] < nums[right]) right = mid;
            else left = mid+1;
        }
        return nums[right];
    }
}