class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> helper = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            helper.add(nums[i]);
        }
        System.out.println(helper);
        Integer[] setArray = helper.toArray(new Integer[helper.size()]);
        Arrays.sort(setArray);
        if(setArray.length==1){
            return setArray[0];
        }
        if(setArray.length<3){
            if(setArray[0]>setArray[1]) return setArray[0];
            else return setArray[1];
        }
        return setArray[setArray.length-3];
    }
}