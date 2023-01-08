class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // List<List<Integer>> ans = new ArrayList<>();
        // HashSet<Integer> set1 = new HashSet<>();
        // HashSet<Integer> set2 = new HashSet<>();
        // Iterator<Integer> it = set1.iterator();
        // int i=0;
        // for(i=0;i<nums1.length;i++){
        //     set1.add(nums1[i]);
        // }
        // for(i=0;i<nums2.length;i++){
        //     set2.add(nums2[i]);
        // }
        // while(it.hasNext()){
        //     if(set2.contains(it.next())){
        //         set1.remove(it.next());
        //         set2.remove(it.next());
        //     }
        // }
        // List<Integer> list1 = new ArrayList<>(set1);
        // List<Integer> list2 = new ArrayList<>(set2);
        // ans.add(list1);
        // ans.add(list2);
        // return ans;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
      for(int i : nums1) {
          s1.add(i);
      }  
      for(int i : nums2) {
          s2.add(i);
      }
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(new ArrayList());
      ans.add(new ArrayList());
       for(int i : s1){
            if(!s2.contains(i)){
                ans.get(0).add(i);
            }
        }
        for(int i : s2){
            if(!s1.contains(i)){
                ans.get(1).add(i);
            }
        }
        
        return ans; 
    }
}