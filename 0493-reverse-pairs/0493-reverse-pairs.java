class Solution {
    public int reversePairs(int[] nums) {
        //BRUTE FORCE NOT WORKING FOR BOUNDARY CASES
        // int count = 0;
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i] > (2 * nums[j])) count++;
        //     }
        // }
        // return count;

        // MERGE SORT APPROACH
        return mergeSort(nums, 0, nums.length-1);
    }
    public int mergeSort(int[] nums, int low, int high){
        if(low >= high) return 0;
        int mid = (low + high)/2;
        int ans = mergeSort(nums, low, mid);
        ans += mergeSort(nums, mid+1, high);
        ans += merge(nums, low, mid, high);
        return ans;
    }
    public int merge(int[] nums, int low, int mid, int high){
        int ans = 0;
        int j = mid + 1;
        for(int i = low; i <= mid; i++){
            while(j <= high && nums[i] > (2 * (long)nums[j])){
                j++;
            }
            ans += (j - (mid + 1));
        }
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]) temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);
        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i - low);
        }
        return ans;
    }
}