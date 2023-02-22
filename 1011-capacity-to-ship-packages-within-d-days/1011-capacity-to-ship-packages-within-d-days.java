class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //sorting an array is not required becoz we mid elemets is a weight we are assuming, its not from the array. and we are applying bs on the weight.
        int maxLoad = 0;
        int totalLoad = 0;
        for(int weight : weights){
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        int low = maxLoad, high = totalLoad;
        
        while(low < high){
            int mid = (low + high)/2;
            if(bsHelper(weights, days, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    public boolean bsHelper(int[] weights, int days, int mid){
        int currLoad = 0, currDays = 1;
        for(int weight : weights){
            currLoad += weight;
            if(currLoad > mid){
                currDays++;
                currLoad = weight;
            }
        }
        return currDays <= days;
    }
}