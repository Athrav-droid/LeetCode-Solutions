class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // if(nums1.length<nums2.length){
        //     for(int i=0;i<nums1.length;i++){
        //         for(int j=0;j<nums2.length;j++){
        //             if(nums1[i] == nums2[j]) return nums1[i];
        //         }
        //     }
        // }else{
        //     for(int i=0;i<nums2.length;i++){
        //         for(int j=0;j<nums1.length;j++){
        //             if(nums2[i] == nums1[j]) return nums2[i];
        //         }
        //     }
        // }
        // return nums1[0];
        
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];
            if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }
}