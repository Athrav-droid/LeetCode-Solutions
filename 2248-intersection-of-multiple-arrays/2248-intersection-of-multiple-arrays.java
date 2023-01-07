class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(freq.containsKey(nums[i][j])){
                freq.put(nums[i][j],freq.get(nums[i][j])+1);
                }else{
                    freq.put(nums[i][j],1);
                }
            }
        }
        for(int key: freq.keySet()){
            if(freq.get(key) == nums.length) ans.add(key);
        }
        Collections.sort(ans);
        return ans;
    }
}