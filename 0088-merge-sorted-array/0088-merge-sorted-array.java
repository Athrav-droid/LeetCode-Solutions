class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> helper = new ArrayList<>();
        int i=0,j=0;
        while(m>0&&n>0){
            if(nums1[i] < nums2[j]){
                helper.add(nums1[i]);
                i++;m--;
            }else{
                helper.add(nums2[j]);
                j++;n--;
            }
        }
        while(m>0){
            helper.add(nums1[i]);
            i++;m--;
        }
        while(n>0){
            helper.add(nums2[j]);
            j++;n--;
        }
        for(int k=0;k<helper.size();k++){
            nums1[k] = helper.get(k);
        }
    }
}