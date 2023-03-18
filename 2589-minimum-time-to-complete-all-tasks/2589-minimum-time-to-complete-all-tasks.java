class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2) -> (t1[1] - t2[1]));
        boolean[] vis = new boolean[2001];
        int count = 0;
        for(int[] task : tasks){
            for(int i = task[0]; i <= task[1]; i++) if(vis[i]) task[2]--;
            for(int i = task[1]; task[2] > 0; i--){
                if(!vis[i]){
                    task[2]--;
                    vis[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}