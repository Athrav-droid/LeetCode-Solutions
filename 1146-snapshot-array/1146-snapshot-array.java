class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] records;
    public SnapshotArray(int length) {
        records = new TreeMap[length];
        for(int i = 0; i < length; i++){
            records[i] = new TreeMap<Integer, Integer>();
            records[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        records[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snapId) {
        return records[index].floorEntry(snapId).getValue();
    }
    // here floor entry method is a Treemap method which return the greatest available value from the treeMap
    // i.e it return the maximum value equal to or less than id.
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */