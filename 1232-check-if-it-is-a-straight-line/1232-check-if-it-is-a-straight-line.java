class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        for(int i = 0; i < coordinates.length - 2; i++){
            if(!isColinear(i, coordinates)) return false;
        }
        return true;
    }
    // (X1 * (Y2 - Y3) + X2 * (Y3 - Y1) + X3 (Y1 - Y2)) != 0
    public boolean isColinear(int i, int[][] c){
        int first = (c[i][0] * (c[i+1][1] - c[i+2][1]));
        int second = (c[i+1][0] * (c[i+2][1] - c[i][1]));
        int third = (c[i+2][0] * (c[i][1] - c[i+1][1]));
        if((first + second + third) != 0) return false;
        else return true;
    }
}