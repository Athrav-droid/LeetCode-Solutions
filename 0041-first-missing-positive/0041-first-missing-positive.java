class Solution {
    public int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++) System.out.println(nums[i]);
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] < 1){
        //         System.out.println(count);
        //         count++;
        //     }else if(nums[i] != i-count) return i-count;
        // }
        // return nums[nums.length - 1] + 1;
        Map<Integer,Integer> helper = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            helper.put(nums[i],1);
        }
        for(int i=1;;i++){
            if(!helper.containsKey(i)) return i;
        }
    }
}