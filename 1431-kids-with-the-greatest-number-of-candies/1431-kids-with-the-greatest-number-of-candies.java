class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> arr = new ArrayList<>();
        int maxim = maxi(candies);
        for(int i =0;i<candies.length;i++){
            if((candies[i]+extraCandies) >= maxim){
                arr.add(true);
            }else{
                arr.add(false);
            }
        }
        return arr;
    }
   public int maxi(int[] arr){
       int maxim =0;
       for(int i=0;i<arr.length;i++){
          if(arr[i] > maxim){
              maxim = arr[i];
          } 
       }
       return maxim;
   }
}