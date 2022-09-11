class Solution {
    public int[] searchRange(int[] arr, int num) {
            int[] ans = {-1,-1};
            int start = search(arr,num,true);
            int end = search(arr,num,false);
            ans[0] = start;
            ans[1] = end;
            return ans ;
        }

    int search(int[] arr , int num , boolean isCheck){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                ans = mid;
                if(isCheck){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}