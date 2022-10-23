class Solution {
    public int[] findErrorNums(int[] nums) {
        //using hashset
        HashSet<Integer> set = new HashSet<>();  //created new hashset
        int a=0,b=0;  //variables for answers
        for(int i=0;i<nums.length;++i){  // loop to check the duplicate 
            if(set.contains(nums[i])){  //for 1 it check set contain 1 or not if not then add 1 in set similarly for other. the if condition we become true only when any number repeat itself as on checking in set we will find it inside the set
                a = nums[i];
            }
            set.add(nums[i]);
        }
        for(int i = 1;i<=nums.length;i++){ //loop to check the element not present in array
            if(set.contains(i) == false){ // if set does not contain any value till nums length then if condition become true and we will record that element.
                b = i;
                break;
            }
        }
        return new int[]{a,b};
    }
}