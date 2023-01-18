class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=0,j=1;
        ArrayList<Integer> helper = new ArrayList<>();
        while(helper.size()<k){
            if(arr[i] != j){
                helper.add(j);
                j++;
            }else{
                if(i < arr.length -1) i++;
                j++;
            }
        }
        return helper.get(k-1);
    }
}