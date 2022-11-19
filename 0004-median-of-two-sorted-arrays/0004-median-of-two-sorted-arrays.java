class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> helper = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            helper.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            helper.add(nums2[i]);
        }
        Collections.sort(helper);
        System.out.println(helper);
        int size = helper.size();
        if(size==0){
            return 0;
        }
        if(size==1){
            return helper.get(0);
        }
        System.out.println(helper.get(size/2-1));
        if(size % 2 == 1){
            return helper.get(size/2);
        }else{
            return(double)( helper.get(size/2) + helper.get(size/2-1) )/2;
        }
    }
}