class Solution {
    public boolean checkValid(int[][] board) {
        int m = board.length;
        int k = board[0].length;
        Set<String> helper = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                int n = board[i][j];
                if(n != '.'){
                    if(helper.contains(n+"r"+i) || helper.contains(n+"c"+j)){
                        return false;
                    }
                }
                helper.add(n+"r"+i);
                helper.add(n+"c"+j);
            }
        }
        return true;
    }
}