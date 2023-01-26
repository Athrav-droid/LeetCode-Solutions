class Solution {
    public boolean isValidSudoku(char[][] board) {
        //These code will only check whether the sudoku is solvable or not for current given elements. It will not check if the sudoku if filled completely or solvable completely . it will only check for current given elements.
        //approach:- using set to identify the elements , r represents row , c for column and g for grid, if any of the value is contained already in the present row, column, grid then we will return false and if not so then we will return true
        Set<String> helper = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char n = board[i][j];
                if(n != '.'){
                    if(helper.contains(n+"r"+i) || helper.contains(n+"c"+j) || helper.contains(n+"g"+i/3+j/3)){
                        return false;
                    }
                }
                helper.add(n+"r"+i);
                helper.add(n+"c"+j);
                helper.add(n+"g"+i/3+j/3);
            }
        }
        return true;
    }
}