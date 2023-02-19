class Solution {
    public int[] sortArray(int[] nums) {
        //INSERTION SORT O(n^2)
        // for(int i = 1; i < nums.length ; i++){
        //     int j = i - 1;
        //      while((j >= 0) && nums[j] > nums[i]){
        //          nums[j+1] = nums[j];
        //          j--;
        //      }
        //      nums[j+1] = nums[i];
        // }
        // return nums;

        //MERGE SORT
        int[] temp = new int[nums.length]; //instead of using a single temp array we can also use two arrays left and right of half-half sizes.
        mergeSort(nums, 0, nums.length-1, temp);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp){
        //calculating start of both arrays
        int start1 = left;
        int start2 = mid + 1;
        //calculating sizes of both arrays
        int s1 = mid - left + 1;
        int s2 = right - mid;
        //copying elements in temp array
        for(int i=0; i<s1; i++){
            temp[start1 + i] = nums[start1 + i];
        }
        for(int i=0; i<s2; i++){
            temp[start2 + i] = nums[start2 + i];
        }
        //Merging Elements
        int i=0, j=0, k=left;
        while(i < s1 && j < s2){
            if(temp[start1 + i] <= temp[start2 + j]){
                nums[k] = temp[start1 + i];
                i++;
            }else{
                nums[k] = temp[start2 + j];
                j++;
            }
            k++;
        }
        while(i < s1){
            nums[k] = temp[start1 + i];
            i++;k++;
        }
        while(i < s2){
            nums[k] = temp[start2 + j];
            j++;k++;
        }
    }
}