class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        ans = generate(rowIndex+1);
        return ans.get(rowIndex);
    }
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> helper = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1){
                    helper.add(1);
                }else{
                    helper.add(ans.get(i-2).get(j-1) + ans.get(i-2).get(j)); // i-2 because we started from but the index is 0 based.
                }
            }
            ans.add(helper);
        }
        return ans;
    }
}