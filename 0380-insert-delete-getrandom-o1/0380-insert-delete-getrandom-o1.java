class RandomizedSet {
    Set<Integer> ourSet = new HashSet<>();
    List<Integer> ourList = new ArrayList<>();
    public RandomizedSet() {
        
        
    }
    
    public boolean insert(int val) {
        if(ourSet.add(val)){
            ourList.add(val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(ourSet.remove(val)){
            ourList.remove(new Integer(val));
            return true;
        }else return false;
        
    }
    
    public int getRandom() {
        int ele = (int)(Math.random() * ourList.size());
        System.out.print(ele);
        return ourList.get(ele);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */