// class Solution {
//     public int findSmallestInteger(int[] nums, int value) {
//         boolean[] vis = new boolean[value];
//         for(int num : nums){
//             if((num % value) < 0) vis[(num % value) + value] = true;
//             else vis[num % value] = true;
//         }
//         int ans = 0;
//         while(true){
//             if(ans >= value) return ans;
//             if(!vis[ans]) return ans;
//             ans++;
//         }
//         // Arrays.sort(nums);
//         // Set<Integer> set = new HashSet<>();
//         // for(int i = 0; i < nums.length; i++){
//         //     nums[i] = Math.abs(nums[i]);
//         //     while(nums[i] - value >= 0){
//         //         nums[i] -= value;
//         //     }
//         //     set.add(nums[i]);
//         //     if(i - 1 >= 0) if(!set.contains(nums[i-1])) break;
//         // }
//         // int i = 0;
//         // while(true){
//         //     if(!set.contains(i)) return i;
//         //     i++;
//         // }
//     }
// }
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int vis[]=new int[value];
        for(int num :nums){
            if(num % value < 0) vis[(num % value) + value]++;
           else vis[Math.abs(num) % value]++; 
        }
        int ans = 0; 
        while(true){
            if(vis[ans % value] == 0) return ans;
            vis[ans % value]--;
            ans++;
        }
    }
}