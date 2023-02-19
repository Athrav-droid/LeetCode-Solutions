class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0) dead(board, i, j, ans);
                else live(board, i, j, ans);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
    int[] row = {-1,0,1,0,-1,1,-1,1};
    int[] col = {0,1,0,-1,-1,-1,1,1};

    public void dead(int[][] board, int i, int j, int[][] ans){
        int countLive = 0;
        int countDead = 0;
        for(int k = 0; k < row.length; k++){
            int newRow = i + row[k];
            int newCol = j + col[k];
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if(board[newRow][newCol] == 0) countDead++;
            else countLive++;
        }
        if(countLive == 3) ans[i][j] = 1;
        else ans[i][j] = 0;
        return;
    }

    public void live(int[][] board, int i, int j, int[][] ans){
        int countLive = 0;
        int countDead = 0;
        for(int k = 0; k < row.length; k++){
            int newRow = i + row[k];
            int newCol = j + col[k];
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if(board[newRow][newCol] == 0) countDead++;
            else countLive++;
        }
        if(countLive < 2) ans[i][j] = 0;
        else if(countLive == 2 || countLive == 3) ans[i][j] = 1;
        else if(countLive > 3) ans[i][j] = 0;
        return;
    }
}