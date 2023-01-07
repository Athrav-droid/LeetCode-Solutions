class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = (nums1.length>nums2.length) ? nums1.length : nums2.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> helper = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
             set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
             set2.add(nums2[i]);
        }
        for(int i:set1){
            for(int j:set2){
                if(i==j) helper.add(i);
            }
        }
        int[] ans = new int[helper.size()];
        for(int i=0;i<helper.size();i++){
            ans[i] = helper.get(i);
        }
        return ans;
        // int n = (nums1.length>nums2.length) ? nums1.length : nums2.length;
        // HashMap<Integer,Integer> freq = new HashMap<>();
        // List<Integer> helper = new ArrayList<>();
        // int[] ans = new int[n];
        // for(int i=0;i<nums1.length;i++){
        //     if(freq.containsKey(nums1[i])){
        //     freq.put(nums1[i],freq.get(nums1[i])+1);
        //     }else{
        //         freq.put(nums1[i],1);
        //     }
        // }
        // for(int i=0;i<nums2.length;i++){
        //     if(freq.containsKey(nums2[i])){
        //     freq.put(nums2[i],freq.get(nums2[i])+1);
        //     }else{
        //         freq.put(nums2[i],1);
        //     }
        // }
        // for(int key: freq.keySet()){
        //     if(freq.get(key) == 2) helper.add(key);
        // }
        // for(int i=0;i<helper.size();i++){
        //     ans[i] = helper.get(i);
        // }
        // return ans;
    }
}