class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(s.toCharArray(), 0, ans);
        return ans;
    }
    public void helper(char[] arr, int i, List<String> ans){
        if( i >= arr.length ){
            ans.add(String.valueOf(arr));
            return;
        }
        char c = arr[i];
        if( c >= '0' && c <= '9') helper(arr, i+1, ans);
        else{
            arr[i] = Character.toUpperCase(arr[i]);
            helper(arr, i+1, ans);
            arr[i] = Character.toLowerCase(arr[i]);
            helper(arr, i+1, ans);
        }
    }
}