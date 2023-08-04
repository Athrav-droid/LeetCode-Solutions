class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        // Finding the Dip
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        // if no Dip is found then return the sorted version of array as it will be the first input
        if(index == -1){
            Arrays.sort(nums);
            return;
        }
        // swapping 
        int swapIdx = n - 1;
        for(int i = n - 1; i > index; i--){
            if(nums[index] < nums[i]){
                swapIdx = i;
                break;
            }
        }
        swap(nums, index, swapIdx);
        revArray(nums, index + 1, n - 1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void revArray(int[] nums, int i, int j){
        while(i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}