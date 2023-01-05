class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrow = 0;
        int lastIndex = 0;
        //on basis of second value we sorted the array 
        Arrays.sort(points,(a,b)->(Integer.compare(a[1],b[1])));
        //after sorting, we check that if 1st value of ith index is greater than the last value of the last index .... if that so then increase the arrow since it don't meet the condition xstart <= x <= xend. update the last index with i .
        for(int i=0;i<points.length;i++){
            if(arrow==0||points[i][0]>points[lastIndex][1]){
                arrow++;
                lastIndex = i;
            }
        }
        return arrow;
    }
}