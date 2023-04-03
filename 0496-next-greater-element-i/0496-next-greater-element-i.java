class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[m];
        s.add(nums2[n-1]);
        map.put(nums2[n-1], -1);
        for(int i = n - 2; i >= 0; i--){
            while(!s.isEmpty() && s.peek() < nums2[i]){
                s.pop();
            }
            if(s.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], s.peek());
            s.push(nums2[i]);
        }
        for(int i = 0; i < m; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}