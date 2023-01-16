class Solution {
    //"start" of the intervals are sorted intervals are not overlapped (i.e. the end of an interval is smaller than the start of next interval, otherwise they are overlapped and should be merged into one)

    //These function will check whether the intervals overlap or not ... approach since intervals are sorted in ascending order according to the start(first element) so we will check the end(second element and the start of next interval) and return boolean that is overlaps (true) or not (false);
    public boolean checkOverlapping(int[] a, int[] b){
        return a[1] >= b[0];
        
    }
    
    //These function will merge two subarray into one and return it ... it is used with overlapping when returning true then merging the intervals;
    public int[] merge(int[] a,int[] b){
        int[] newInterval = {Math.min(a[0],b[0]),Math.max(a[1],b[1])};
        return newInterval;
    }
    
    // These function is used to add the interval i.e new Interval in the intervals array . These is the first step to be done so that after inserting we can check and remove the overlaps.
    public int[][] addInterval(int[][] intervals, int[] newInterval){
        boolean isIntervalInserted = false; //used because if every start is smaller than newIntervals start then we will add the new interval in the last;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals)); // converting array to list to use add operation 
        for(int i=0;i<intervals.length;i++){ //to find the correct position in intervals
            if(intervals[i][0] > newInterval[0]){
                isIntervalInserted = true; //if found set it to true to that we dont add new interval again in the last;
                list.add(i,newInterval);
                break;
            }
        }
        if(!isIntervalInserted) list.add(newInterval);
        return list.toArray(new int[list.size()][2]); // again returning a array;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        //inserted new interval in intervals.
        intervals = addInterval(intervals,newInterval);
        // ans list return krte vkt isko vps array m change kr denge
        List<int[]> ans = new ArrayList<>();
        // checking for every intervals element
        for(int i=0;i<intervals.length;i++){
            int[] curr = {intervals[i][0],intervals[i][1]}; //curr m le liya usko interval ko (i vale ko);
            while(i<intervals.length && checkOverlapping(curr,intervals[i])){ //agr overlapping hoga to merge krdenge and curr m hi store krdenge and jb tk curr k liye overlapp milta jayega tb tk krenge 
                curr = merge(curr,intervals[i]);
                i++;
            }
            i--;
            ans.add(curr);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}