class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Dijkstra Algorithm
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        for(int[] flight : flights){ // adding values in adjacency list
            adjList.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); //ascending sorting
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int dist = temp[0];
            int curr = temp[1];
            int steps = temp[2];

            if(steps > minStops[curr] || steps > k + 1) continue;
            minStops[curr] = steps;
            if(curr == dst) return dist;
            if(!adjList.containsKey(curr)) continue;
            for(int[] key : adjList.get(curr)){
                pq.offer(new int[]{dist + key[1], key[0], steps + 1});
            }
        }
        return -1;
    }
}