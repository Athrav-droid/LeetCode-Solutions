class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return ans;
    }
    public void helper(int[] nums, int start){
        if(start == nums.length){
            List<Integer> newList = new ArrayList<>();
            for(int c : nums){
                newList.add(c);
            }
            ans.add(newList);
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            helper(nums,start+1);
            swap(nums,i,start);
        }
    }
    public void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // List<List<Integer>> ans = new ArrayList<>();
    // public List<List<Integer>> permute(int[] nums) {
    //     List<Integer> newList = new ArrayList<>();
    //         for(int c : nums){
    //             newList.add(c);
    //         }
    //     helper(newList,0);
    //     return ans;
    // }
    // public void helper(List<Integer> nums, int start){
    //     if(start == nums.size()){
    //         ans.add(nums);
    //     }
    //     for(int i=start;i<nums.size();i++){
    //         Collections.swap(nums,nums.get(i),nums.get(start));
    //         helper(nums,start+1);
    //         Collections.swap(nums,nums.get(i),nums.get(start));
    //     }
    // }
    // public void swap(int a,int b){
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }
    //Linked hashset used .. read defination
    // public List<List<Integer>> permute(int[] nums) {
    //     helper(nums,new LinkedHashSet<Integer>());
    //     return ans;
    // }
    // public void helper(int[] nums,LinkedHashSet<Integer> i){
    //     if(i.size() == nums.length){ //if lenght of hashset is equals to length of nums then add to ans arraylist and return 
    //         ans.add(new ArrayList<Integer>(i));
    //         return;
    //     }
    //     //two possiblities ... first take and second remove
    //     for(int j=0;j<nums.length;j++){
    //         if(i.contains(nums[j])) continue;
    //         i.add(nums[j]); 
    //         helper(nums,i);
    //         i.remove(nums[j]);
    //     }
    // }
}