class Solution {
    public int shortestBridge(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        boolean found = false;
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    found = true;
                    dfs(grid, i, j, queue, vis);
                    break;
                }
            }
            if(found) break;
        }
        int ans = -1;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int newRow = dir[0] + curr[0];
                    int newCol = dir[1] + curr[1];

                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= n || vis[newRow][newCol]) continue;
                    if(grid[newRow][newCol] == 1) return ans;
                    vis[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, int row, int col, Queue<int[]> queue, boolean[][] vis){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || vis[row][col]) return;
        queue.offer(new int[]{row, col});
        vis[row][col] = true;
        dfs(grid, row + 1, col, queue, vis);
        dfs(grid, row - 1, col, queue, vis);
        dfs(grid, row, col + 1, queue, vis);
        dfs(grid, row, col - 1, queue, vis);
    }
}