class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);  //helper recursive function
    }
    
    public boolean helper(char[][] board, int row, int col){
        if(row == board.length){  //base case when reach the last row then return true,
            return true;
        }
        int nrow = 0;  // can't use row and col directly so defined another variable nrow and ncol initialized with 0
        int ncol = 0;  //this variables are for the iteration.
        if( col != board.length -1){  //if column is not the last column of the board then same row but increase the column
            nrow = row;
            ncol = col + 1;
        }else{  //if the last column of the board then set the column to 0 and increase the row..here things are done using row so we have condition of row in the base case
            nrow = row + 1;
            ncol = 0;
        }
        
        if(board[row][col]!='.'){ // if a value is already present at the block then call the recursive function with the updated row and col and if it returns true {means calls continues throughout the base condition and returns true everytime then this condition should also return true} returns true by this function also 
            if(helper(board,nrow,ncol)){
                return true;
            }
        }else{  //else we will put one value from the 1..9 
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){  //condition will check if the block is safe to put the following value or not ... if true then put the value to that block and call the helper function for further work {again if true by all ahead conditions then it will also return true} and it will return true if it's true for the further conditions
                    board[row][col] = (char)(i+'0');  //If you add '0' with int variable, it will return actual value in the char variable. The ASCII value of '0' is 48. So, if you add 1 with 48, it becomes 49 which is equal to 1. The ASCII character of 49 is 1. and then typecasting it in character as we have char's in the board.
                    if(helper(board,nrow,ncol)){
                        return true;
                    }else{  //if not true for the further condition then make the block empty again {Backtracing} and again put a different value
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false; 
    }
    
    public boolean isSafe(char[][] board, int row, int col, int num){  //function to check if the block is Safe to put the value or not 
        for(int i=0;i<board.length;i++){  //for row and column
            if(board[i][col] == (char)(num + '0')){
                return false;
            }
            if(board[row][i] == (char)(num + '0')){
                return false;
            }
        }
        //for the grid
        int startrow = (row/3) * 3;  //this will give starting row of the grid as if we are on the 4th row then 4/3 = 1 and 1*3 will be equal to the starting block/row of the respective grid
        int startcol = (col/3) * 3; //this will give starting col of the grid as if we are on the 4th col then 4/3 = 1 and 1*3 will be equal to the starting block/col of the respective grid
        for(int sr=startrow;sr<startrow+3;sr++){  //nested loop for the grid iteration to check if the value existed or not .
            for(int sc=startcol;sc<startcol+3;sc++){
                if(board[sr][sc] == (char)(num + '0')){
                    return false;
                }
            }
        }
        return true;
    }
}