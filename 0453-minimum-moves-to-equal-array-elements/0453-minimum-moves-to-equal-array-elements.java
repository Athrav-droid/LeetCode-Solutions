class Solution {
    public int minMoves(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.abs(nums[0]-nums[i]);
        }
        return sum;
    }
    // int max = 0;
    // int count = 0;
    // Set<Integer> s = new HashSet<>();
    // public int minMoves(int[] nums) {
    //     s = convert(nums);
    //     if(s.size() == 1){
    //         return count;
    //     }
    //     for(int i=0;i<nums.length-1;i++){
    //         if(nums[i]>max) max = nums[i];
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=max){
    //             nums[i]++;
    //         }
    //     }
    //     count++;
    //     minMoves(nums);
    //     return count;
    // }
    // Set<Integer> convert(int[] array)
    // {
    //     // Hash Set Initialisation
    //     Set<Integer> Set = new HashSet<>();
  
    //     // Iteration using enhanced for loop
    //     for (int element : array) {
    //         Set.add(element);
    //     }
    //     // returning the set
    //     return Set;
    // }
}