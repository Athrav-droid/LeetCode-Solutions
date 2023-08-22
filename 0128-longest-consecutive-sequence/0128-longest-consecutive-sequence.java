class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i : nums) set.add(i);
        for(int i : nums){
            if(!set.contains(i - 1)){
                int count = 0;
                for(int j = i; j < 1000000000; j++){
                    if(set.contains(j)) count++;
                    else break;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
        
        // if(nums.length < 2) return nums.length;
        // Arrays.sort(nums);
        // int ans = 0;
        // int count = 0;
        // for(int i=0;i<nums.length;i++){
        //     while(i<nums.length-1){
        //         if(Math.abs(nums[i]-nums[i+1]) == 0){
        //             i++;
        //         }else if(Math.abs(nums[i]-nums[i+1]) == 1){
        //             i++;count++;
        //         }else break;
                
        //     }
        //     ans = Math.max(ans,count);
        //     count=0;
        // }
        // return ans+1;
    }
}