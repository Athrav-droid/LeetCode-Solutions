class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0) if(nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        if(!ans.contains(new ArrayList<>(temp))){
                            ans.add(new ArrayList<>(temp));
                        }
                        k++; l--;
                        while(k - 1 >= 0 && k < l && nums[k] == nums[k - 1]) k++;
                        while(l + 1 < n && k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                    
                }
            }
        }
        return ans;






        // int n = nums.length;
        // List<List<Integer>> ans = new ArrayList<>();
        // Arrays.sort(nums);
        // for(int i = 0; i < n; i++){
        //     int newTar = nums[i];
        //     for(int j = i + 1; j < n; j++){
        //         int newTa = newTar + nums[j];
        //         for(int k = j + 1; k < n; k++){
        //             int newT = newTa + nums[k];
        //             for(int l = k + 1; l < n; l++){
        //                 int neww = newT + nums[l];
        //                 if(neww == target) {
        //                     List<Integer> temp = new ArrayList<>();
        //                     temp.add(nums[i]);
        //                     temp.add(nums[j]);
        //                     temp.add(nums[k]);
        //                     temp.add(nums[l]);
        //                     if(!ans.contains(new ArrayList<>(temp))){
        //                         ans.add(new ArrayList<>(temp));
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return ans;
    }
}