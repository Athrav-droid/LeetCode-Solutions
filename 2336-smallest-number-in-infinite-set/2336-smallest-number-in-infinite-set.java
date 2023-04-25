class SmallestInfiniteSet {
    private Set<Integer> set;
    private PriorityQueue<Integer> pq;
    private Integer curr;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
        curr = 1;
    }
    
    public int popSmallest() {
        int ans;
        if(!pq.isEmpty()){
            ans = pq.poll();
            set.remove(ans);
        }else{
            ans = curr;
            curr += 1;
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(curr <= num || set.contains(num)) return;
        set.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */