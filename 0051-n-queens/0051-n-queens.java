class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>(); // since we have to return list of list of String so created a new array list of the same type named allBoards.
        char[][] board = new char[n][n]; //created a char 2D array for size n*n since we have to add 'Q' or '.' if there is queen or no queen respectively.
        helper(board,allBoards,0); // helper function to help us check for queen placement and return the arrayList.
        return allBoards; // after all the function call we are provided with the allBoards ArrayList 
        
    }
    
    public void helper(char[][] board,List<List<String>> allBoards,int col){ //recursive function:- taking board,allBoard and col as input parameter.
        if(col == board.length){ //base condition 
            saveBoard(board,allBoards); //another function to save the board in allBoards.
            return;
        }
        for(int row=0;row<board.length;row++){ //for every row in column check that Queen is safe to place at that row and col or not if it is safe then mark the board[row][col] with the 'Q' and call the recursive function for the next column since we know in one col only one Queen can be placed.
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                helper(board,allBoards,col+1);
                board[row][col] = '.'; //Backtracing used as if the following recursive call doesn't lead to the successful Queens placement at all the position then we will come back and mark the block as '.' means Queen is not safe to place there and we will move to the next row element.
            }
        }
    }
    
    public boolean isSafe(int row, int col, char[][] board){ // isSafe function checks that if the placement of Queen at that position is safe or not.
        //Make sure to read the condition twice as it can cause errors in code for no reason
        //vertical check
        for(int i=0;i<board.length;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //horizontal check
        for(int j=0;j<board.length;j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        //top left check or upper left
        int r = row;
        for(int c=col;r>=0 && c>=0;r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //top right check or upper right
        r = row;
        for(int c=col;r>=0 && c<board.length;r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //bottom left check or lower left
        r = row;
        for(int c=col;r<board.length && c>=0;r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //bottom right check or lower right
        r = row;
        for(int c=col;r<board.length && c<board.length;r++,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //if row and col passes every condition then return true.
        return true;
    }
    public void saveBoard(char[][] board,List<List<String>> allBoards){
        String row = "";  // created an empty String to add in list
        List<String> newBoard = new ArrayList<>();  // list of String to add in allBoards list
        //since after all the function calls in helper function base condition may reach if so then we will save the board with the respective idea.
        for(int i=0;i<board.length;i++){  //for every row
            row = ""; //reinitialize the value of row every time a row ends
            for(int j=0;j<board.length;j++){ // for every column
                if(board[i][j] == 'Q'){  //if the respective block is Queen then add 'Q' to the row. else add '.' to the row
                    row += 'Q';
                }else{
                    row += '.';
                }
            }
        newBoard.add(row); // in each row after every column iteration add the respective row string to the newBoard then the String row is reinitialized and for the next row same process will continue.
        }
        allBoards.add(newBoard);  //atlast we will add that board or list in our allBoards ArrayList and we will move to the next Board/next possible way to place the queens in the board.
    }
}