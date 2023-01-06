class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if(costs[0] > coins) return 0;
        if(costs[0] == coins) return 1;
        int sum = 0;
        for(int i=0;i<costs.length;i++){
            sum += costs[i];
            System.out.println(sum);
            if(sum==coins) return i+1;
            if(sum>coins) return i;
        }
        return costs.length;
    }
    // int arraySum(int[] arr){
    //     int sum=0;
    //     for(int i=0;i<arr.length;i++){
    //         sum+=arr[i];
    //     }
    //     return sum;
    // }
}