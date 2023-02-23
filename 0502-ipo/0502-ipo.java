class Solution {
    class Pair implements Comparable<Pair>{
        int capital, profit;
        public Pair(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
        public int compareTo(Pair pair) {
            return capital - pair.capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        Pair[] pairs = new Pair[n];

        for(int i=0;i<n;i++){
            pairs[i] = new Pair(capital[i], profits[i]);
        }
        Arrays.sort(pairs);
        // PriorityQueue is a min heap, but we need a max heap, so we use Collections.reverseOrder()
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());
        int index = 0;
        for(int i = 0; i < k; i++){
            while(index < n && pairs[index].capital <= w){
                q.add(pairs[index].profit);
                index++;
            }
            if(q.isEmpty()) return w;
            w += q.poll();
        }
        return w;

    //      BRUTE FORCE TLE
    //     int n = profits.length;
	//     boolean[] finished = new boolean[n];
	//     for (int i = 0; i < k; i++) {
	// 	    int prjIndex = -1;
	// 	    for (int j = 0; j < n; j++) {
	// 		    if (capital[j] <= w && !finished[j]) {
	// 			    if (prjIndex == -1 || profits[j] > profits[prjIndex]) 
	// 				    prjIndex = j;
	// 		        }   
	// 	        }
	// 	    if (prjIndex == -1) 
	// 	        return w;
	//         w += profits[prjIndex];
	//         finished[prjIndex] = true;
	//     }
	// return w;
    }
}