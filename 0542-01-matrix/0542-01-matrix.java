class Node{
    int first;
    int second;
    int third;
    Node(int _first, int _second, int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];
        int[][] ans = new int[m][n];

        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i,j,0));
                    visited[i][j] = 1;
                }else{
                    visited[i][j] = 0;
                }
            }
        }

        int[] rdir = {-1,0,1,0};
        int[] cdir = {0,1,0,-1};

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            ans[row][col] = steps;
            for(int i=0;i<4;i++){
                int nrow = row + rdir[i];
                int ncol = col + cdir[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    queue.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return ans;
    }
}