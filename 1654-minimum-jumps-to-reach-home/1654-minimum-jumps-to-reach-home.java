class Solution {
    class Pair {
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    /** 
    Logic:- BFS Traversing so minimum ka tension nhi h.
    visited set string type so that we are not visiting same node again with same forward or backward case, if we have visited
    it with forward then backward is allowed and vice versa.
    checking for both cases forward and backward.
    **/
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x == 0) return 0;
        Set<Integer> forbid = new HashSet<>();
        for(int n : forbidden) forbid.add(n);

        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ans = 1;
        int farMost = 10000;

        q.add(new Pair(0, 0));
        visited.add(0 + " " + 0);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                // Forward a 
                int next_a = curr.first + a;
                if(next_a == x) return ans;
                if(next_a >= 0 && next_a <= farMost && !forbid.contains(next_a) && visited.add(next_a + " " + 1)){
                    q.add(new Pair(next_a, 1));
                } 
                // Backward b
                if(curr.second == 1){
                    int next_b = curr.first - b;
                    if(next_b == x) return ans;
                    if(next_b >= 0 && next_b <= farMost && !forbid.contains(next_b) && visited.add(next_b + " " + 0)){
                        q.add(new Pair(next_b, 0));
                    } 
                }
            }
            ans++;
        }
        return -1;
    }
}