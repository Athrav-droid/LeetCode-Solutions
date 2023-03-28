class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int ans = 0;
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        queue.offer(new int[]{0, 0});
        vis[0][0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                if(curr[0] == n - 1 && curr[1] == n - 1) return ans;

                for(int[] dir : dirs){
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= n 
                        || vis[newRow][newCol] || grid[newRow][newCol] == 1) continue;

                    vis[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return -1;
    }
}