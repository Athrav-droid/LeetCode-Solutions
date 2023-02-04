class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Stack<Integer> curr = new Stack<>();
            if(nums[i] > 9){
                while(nums[i] > 0){
                int temp = nums[i] % 10;
                curr.push(temp);
                nums[i] = nums[i] / 10;
                }
            }else{
                ans.add(nums[i]);
            }
            while(!curr.isEmpty()){
                ans.add(curr.pop());
            }
        }
        int[] arr = new int[ans.size()];
        int index = 0;
        for (int i = 0; i < ans.size(); i++) {
            arr[index++] = ans.get(i);
        }
        return arr;
    }
}