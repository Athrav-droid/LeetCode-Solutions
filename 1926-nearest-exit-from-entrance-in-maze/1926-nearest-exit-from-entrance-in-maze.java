class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; 
        int n = maze[0].length;

        if(maze == null || m == 0 || n == 0) return -1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        int ans = 0;

        queue.offer(entrance);
        vis[entrance[0]][entrance[1]] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                for(int[] dir : dirs){
                    int nR = dir[0] + curr[0];
                    int nC = dir[1] + curr[1];
                    if(nR < 0 || nC < 0 || nR >= m || nC >= n || vis[nR][nC] || maze[nR][nC] == '+') continue;
                    if(nR == 0 || nR == m - 1 || nC == 0 || nC == n - 1){
                        if(nR == entrance[0] && nC == entrance[1]) continue;
                        return ans;
                    }
                    vis[nR][nC] = true;
                    queue.offer(new int[]{nR, nC});
                }
            }
        }
        return -1;
    }
}