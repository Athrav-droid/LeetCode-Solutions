class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //Traversing the boundaries and all the O connected with bounderies turning to * .
        for(int i=0;i<m;i++){
            helper(board, i, 0);
            helper(board, i, n-1);
        }

        for(int i=0;i<n;i++){
            helper(board, 0, i);
            helper(board, m-1, i);
        }
        //after that remaining O are converted to X means they are not attached to any of the boundries and then * are converted to O
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    public void helper(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == '*') return;
        board[i][j] = '*';
        helper(board, i-1, j);
        helper(board, i+1, j);
        helper(board, i, j+1);
        helper(board, i, j-1);
    }
}

