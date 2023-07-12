class Solution {
    // Logic:- To Replace Every Character of mutation string with A, C, G, T
    public int minMutation(String startGene, String endGene, String[] bank) {
        // to quickly access bank using contains property
        Set<String> banker = new HashSet<>();
        for(String s : bank) banker.add(s);
        
        // Base Case
        if(!banker.contains(endGene)) return -1;
        
        // So that we don't repeat any string and stuck in infinite loop
        Set<String> visited = new HashSet<>();
        char[] cArray = {'A', 'C', 'G', 'T'};
        int ans = 0;
        
        // For BFS
        Queue<String> q = new LinkedList<>();
        visited.add(startGene);
        q.offer(startGene);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(endGene)) return ans;

                for(char c : cArray){
                    for(int i = 0; i < curr.length(); i++){
                        String nei = curr.substring(0, i) + c + curr.substring(i + 1);
                        if(!visited.contains(nei) && banker.contains(nei)){
                            visited.add(nei);
                            q.offer(nei);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}