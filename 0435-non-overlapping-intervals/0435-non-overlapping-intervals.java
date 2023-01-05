class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        int ans = 0;
        int prevEnd = intervals[0][1];
        //we started the loop from 1
        for(int i=1;i<intervals.length;i++){
            //since if value is equal or greater than everything is fine so just update the prevEnd and move onto next index
           if(intervals[i][0] >= prevEnd){
               prevEnd = intervals[i][1];
           }else{
               ans++;
               // minimum because we want to check minimum value from both to store in prevEnd as the list is sorted.
               prevEnd = Math.min(prevEnd,intervals[i][1]);
           }
        }
        
        return ans;
    }
}