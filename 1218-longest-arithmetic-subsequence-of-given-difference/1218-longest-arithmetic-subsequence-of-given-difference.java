class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            if(dp.containsKey(arr[i] - diff)){
                dp.put(arr[i], dp.get(arr[i] - diff) + 1);
            }else{
                dp.put(arr[i],1);
            }
            ans = Math.max(ans, dp.get(arr[i]));
        }
        return ans;
    }
}