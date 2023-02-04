class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        boolean[][] check = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(found(board,wordArr,i,j,0,check)) return true;
            }
        }
        return false;
    }
    public boolean found(char[][] board, char[] wordArr, int row, int col, int index, boolean[][] check){
        if(index == wordArr.length) return true;
        if(row<0 || row >= board.length || col<0 || col>= board[row].length || board[row][col] != wordArr[index] || check[row][col] == true) return false;
        check[row][col] = true;
        if(found(board,wordArr,row,col+1,index+1,check)) return true;
        else if(found(board,wordArr,row+1,col,index+1,check)) return true;
        else if(found(board,wordArr,row,col-1,index+1,check)) return true;
        else if(found(board,wordArr,row-1,col,index+1,check)) return true;
        check[row][col] = false;
        return false;
           }
}