class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        for(int i=0;i<nums.length;i++){
            elementSum += nums[i];
        }
        System.out.println(elementSum);
        int absoluteSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <10) absoluteSum+=nums[i];
            else{
                while(nums[i]>0){
                    int last = nums[i] % 10;
                    absoluteSum+=last;
                    nums[i] /= 10;
                }
            }
        }
        System.out.println(absoluteSum);
        return Math.abs(elementSum-absoluteSum);
    }
}