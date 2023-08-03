class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> allStrings = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < nums.length; j++){
                if(nums[j] % p == 0) {
                    count++;
                } 
                if(count > k) break;
                sb.append(nums[j] + ",");
                allStrings.add(sb.toString());
            }
        }
        return allStrings.size();
    }
}