class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> helper = new HashSet<>();
        int n = candyType.length / 2;
        for(int i : candyType){
            helper.add(i);
        }
        if(helper.size() <= n) return helper.size();
        else return n;
    }
}