class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //TWO POINTER METHOD
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0 && nums[i] != nums[i-1])){
                int start = i+1;
                int end = nums.length - 1;
                int sum = 0 - nums[i];
                while(start < end){
                    if(nums[start] + nums[end] == sum){
                        ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while(start < end && nums[start] == nums[start + 1]) start++;
                        while(start < end && nums[end] == nums[end - 1]) end--;
                        start++;end--;
                    }else if(nums[start] + nums[end] < sum){
                        start++;
                    }else end--;
                }
            }
        }
        return ans;
        //BRUTE FORCE Giving TLE
        // int n = nums.length;
        // Arrays.sort(nums);
        // List<List<Integer>> ans = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if((i != j) && (i != k) && (j != k) && (nums[i] + nums[j] + nums[k] == 0)){
        //                 List<Integer> helper = new ArrayList<>();
        //                 helper.add(nums[i]);helper.add(nums[j]);helper.add(nums[k]);
        //                 // Collections.sort(helper);
        //                 if(!ans.contains(helper)) ans.add(helper);
        //             }
        //         }
        //     }
        // }
        // return ans;
    }
}