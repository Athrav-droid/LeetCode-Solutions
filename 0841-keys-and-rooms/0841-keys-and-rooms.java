class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Set<Integer> set = new HashSet<>();
        // set.add(0);
        // for(int i = 0; i < rooms.size(); i++){
        //     for(int j = 0; j < rooms.get(i).size(); j++){
        //         if(rooms.get(i).get(j) == i) continue;
        //         set.add(rooms.get(i).get(j));
        //     }
        // }
        // return set.size() == rooms.size();

        // Map<Integer, List<Integer>> graph = new HashMap<>();
        // for(int i = 0; i < rooms.size(); i++){
        //     for(int j = 0; j < rooms.get(i).size(); j++){
        //         if(rooms.get(i).get(j) == i) continue;
        //         graph.computeIfAbsent(i, value -> new ArrayList<>()).add(rooms.get(i).get(j));
        //     }
        // }
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        vis[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                for(int j = 0; j < rooms.get(curr).size(); j++){
                    int ins = rooms.get(curr).get(j);
                    if(!vis[ins]){
                        vis[ins] = true;
                        queue.offer(ins);
                    }
                }
            }
        }
        for(boolean v : vis){
            if(!v) return false;
        }
        return true;
    }
}