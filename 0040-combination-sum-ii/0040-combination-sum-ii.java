class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, ans, temp, 0);
        return ans;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int start){
        if(target < 0) return;
        else if(target == 0){
            Collections.sort(temp);
            if(!ans.contains(temp)) ans.add(new ArrayList<>(temp));
        }
        else{
            for(int i=start; i<candidates.length;i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], ans, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}