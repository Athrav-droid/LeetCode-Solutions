class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //As we can see that every element is from left side is grater then and smaller the then the its down elements
        // so that's the intutation 
        int row = 0; //first row
        int col = matrix[0].length - 1; //last column
        while(row < matrix.length && col >= 0){ // check not out of bound
            if(matrix[row][col] == target)return true;
            //move to the smaller side
            else if(matrix[row][col] > target)col--;
            //move to the grater side
            else row++;
        }
        return false;
    }
}