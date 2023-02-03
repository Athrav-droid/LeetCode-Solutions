class Solution {
    public int[][] merge(int[][] intervals) {
        // List<List<Integer>> helper = new ArrayList<>();
        // for(int i=0;i<intervals.length-1;i++){
        //     if(check(intervals[i],intervals[i+1])){
        //         List<Integer> merged = new ArrayList<>();
        //         merged.add(intervals[i][0]);
        //         merged.add(intervals[i+1][1]);
        //         helper.add(merged);
        //     }else{
        //         List<Integer> temp = Arrays.asList(intervals[i]);
        //         helper.add(temp);
        //     }
        // }
        // int[] ans = new int[helper.size()];
        // return helper.toArrays(ans);

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> helper = new ArrayList<>();
        for(int[] curr : intervals){
            if(helper.size() == 0) helper.add(curr);
            else{
                int[] prev = helper.get(helper.size() - 1);
                if(prev[1] >= curr[0]) prev[1] = Math.max(prev[1],curr[1]);
                else helper.add(curr);
            }
        }
        return helper.toArray(new int[helper.size()][]);
    }
    // public boolean check(int[] a, int[] b){
    //     if(a[1] >= b[0]) return true;
    //     return false;
    // }
}