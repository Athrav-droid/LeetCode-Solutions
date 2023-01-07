class Solution {
    public String kthDistinct(String[] arr, int k) {
        ArrayList<String> helper = new ArrayList<>();
        Map<String,Integer> freq = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i],freq.get(arr[i])+1);
            }else{
                freq.put(arr[i],1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(freq.get(arr[i]) == 1){
                helper.add(arr[i]);
            }
        }
        for(int i=0;i<helper.size();i++){
            if(i==(k-1)) return helper.get(i);
        }

        return "";
    }
}