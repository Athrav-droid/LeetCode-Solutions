class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) pq.add(i);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            else pq.add(Math.abs(a - b));
        }
        return pq.size() == 0 ? 0 : pq.peek();
        // if(stones.length == 1) return stones[0];
        // if(stones.length == 2){
        //     if(stones[0] == stones[1]) return 0;
        //     else if(stones[0] > stones[1]){
        //         return stones[0] - stones[1];
        //     }else return stones[1] - stones[0];
        // }
        // List<Integer> list = new ArrayList<>();
        // for(int a : stones) list.add(a);
        // Collections.sort(list);
        // while(list.size() > 1){
        //     int last = list.get(list.size() - 1);
        //     int lastsec = list.get(list.size() - 2);
        //     if(last == lastsec){
        //         list.remove(list.size() - 1);
        //         if(list.size() - 2 >= 0) list.remove(list.size() - 2);
        //     }else if(last > lastsec){
        //         list.remove(list.size() - 1);
        //         if(list.size() - 2 >= 0) list.remove(list.size() - 2);
        //         list.add(last - lastsec);
        //     }else{
        //         list.remove(list.size() - 1);
        //         if(list.size() - 2 >= 0) list.remove(list.size() - 2);
        //         list.add(lastsec - last);
        //     }
        //     Collections.sort(list);
        // }
        // return list.size() > 0 ? list.get(0) : 0;
    }
}