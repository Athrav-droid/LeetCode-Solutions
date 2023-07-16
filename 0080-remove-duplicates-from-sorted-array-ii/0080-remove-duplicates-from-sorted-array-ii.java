class Solution {
    public int removeDuplicates(int[] nums) {
        // jb bhi 2 se jyada element ho jaye count m unko ignore krna chalu krdo, and jaise hi value kam ho to vps se
        // rearrange krna chalu krdu piche vali index ke through
        int i = 1;
        int count = 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] == nums[j - 1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}