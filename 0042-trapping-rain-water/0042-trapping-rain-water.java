class Solution {
    public int trap(int[] height) {
        //DP APPROACH
        // int n = height.length;
        // if(height.length == 1) return 0;
        // int ans = 0;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // leftMax[0] = height[0];
        // rightMax[n-1] = height[n-1];
        // for(int i = 1; i < n; i++){
        //     leftMax[i] = Math.max(height[i], leftMax[i-1]);
        // }
        // for(int i = n-2; i>=0; i--){
        //     rightMax[i] = Math.max(height[i], rightMax[i+1]);
        // }
        // for(int i = 1; i < n;i++){
        //     ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        // }
        // return ans;

        //TWO POINTER APPROACH
        int left = 0, right = height.length - 1, ans = 0, leftMax = 0, rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
               if( height[left] >= leftMax ){
                   leftMax = height[left];
               }else{
                   ans += (leftMax - height[left]);
               }
                left++;
            }else{
               if( height[right] >= rightMax ){
                   rightMax = height[right];
               }else{
                   ans += (rightMax - height[right]);
               }
                right--;
            }
        }
        return ans;

        //BRUTE FORCE APPROACH : GIVING TLE
        // int ans = 0;
        // for(int i = 1;i<height.length-1;i++){
        //     int left = i - 1;
        //     int right = i + 1;
        //     int prevLeft = Integer.MIN_VALUE;
        //     int prevRight = Integer.MIN_VALUE;
        //     int steps = 0;
        //     while(height[left] > height[i] && height[right] > height[i]){
        //         if(prevLeft > left || prevRight > right) break;
        //         steps++;
        //         int min = Math.min(left, right);
        //         ans = ans + min + steps - 1;
        //     }
        // }
        // return ans;
    }
}