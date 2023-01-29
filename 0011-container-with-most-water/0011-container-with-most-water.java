class Solution {
    public int maxArea(int[] height) {

        //O(n^2) T.C (TLE & MLE received)
        // int n = height.length;
        // List<Integer> helper = new ArrayList<>();
        // int key = 0;
        // int minHeight = 0;
        // int dist = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         minHeight = Math.min(height[i],height[j]);
        //         dist = i-j;
        //         key = Math.abs(dist*minHeight);
        //         helper.add(key);
        //     }
        // }
        // return Collections.max(helper);

        //Two Pointer Approach(Sliding Window Type) O(n) T.C
        int maxWater = 0, left = 0, right = height.length - 1;
        int width = 0;
        while(left < right){
            width = right-left;
            maxWater = Math.max(maxWater, Math.min(height[left],height[right]) * width);
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return maxWater;
    }
}