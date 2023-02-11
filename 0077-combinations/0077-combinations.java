class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<Integer>(), n,k,1);
        return ans;
    }
    public void helper(List<Integer> help, int n, int k, int start){
        if(k==0){
            ans.add(new ArrayList<>(help));
            return;
        }
        for(int i=start;i<=n;i++){
            help.add(i);
            helper(help,n,k-1,i+1);
            help.remove(help.size()-1);
        }
    }
}