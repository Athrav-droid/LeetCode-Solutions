class Solution {
    public int hIndex(int[] citations) {
        // O(n) Time Complexity
        // int n = citations.length;
        // int index = 0;
        // while(index < n && n - index > citations[index]){
        //     index++;
        // }
        // return n - index;

        // O(logn) Time Complexity // Binary Search:- Since Sorted Array
        int left = 0, right = citations.length - 1;
        int n = citations.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(citations[mid] == n - mid) return n - mid;
            else if(citations[mid] < n - mid) left = mid + 1;
            else right = mid - 1;
        }
        return n - left;
    }
}