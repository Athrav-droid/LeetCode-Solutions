class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int bs = binarySearch2d(matrix,target);
        if(bs == -1) return false;
        else{
            return binarySearch(matrix[bs],target);
        }
    }
    //Binary Search in 2D Matrix
    public int binarySearch2d(int[][] matrix,int target){
        int low = 0;
        int high = matrix.length -1;
        int n = matrix[0].length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(matrix[mid][0] <= target && matrix[mid][n] >= target) return mid;
            if(matrix[mid][n] < target) low = mid + 1;
            else high = mid - 1; 
        }
        return -1;
    }
    //Binary Search in 1D Matrix
    public boolean binarySearch(int[] matrix,int target){
        int low = 0;
        int high = matrix.length -1;
        int n = matrix.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(matrix[mid] == target) return true; 
            if(matrix[mid] < target) low = mid + 1;
            else high = mid -1;
        }
        return false;
    }
}