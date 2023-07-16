class Solution {
    public int minimumIndex(List<Integer> nums) {
    Map<Integer,Integer> freqR = new HashMap<>();
    Map<Integer,Integer> freqL = new HashMap<>();
    for(int num : nums){
        freqR.put(num, freqR.getOrDefault(num, 0) +1);
    }
    for(int i = 0; i < nums.size(); i++){
        int x = nums.get(i);
        freqR.put(x, freqR.getOrDefault(x, 0) -1);
        freqL.put(x, freqL.getOrDefault(x, 0) +1);
        int left = freqL.get(x);
        int right = freqR.get(x);
        if(2 * left > i + 1 && 2 * right > nums.size() - i - 1) return i;
    }
    return -1;


        
    // int n=nums.size();
    // HashMap<Integer,Integer> map=new HashMap<>();
    // int prefix[]=new int[n];
    // int max=0,elem=0;
    // for(int i=0;i<n;i++){
    //     map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
    //     int x=map.get(nums.get(i));
    //     // agr new value badi ho to usko check krlo ki vo dominant h ki nhi 
    //     if(x>max){
    //         max=x;
    //         if(x*2>(i+1)){
    //             elem=nums.get(i);
    //             prefix[i]=elem;
    //         }
    //     // agr new value dominant na ho to purani ko check krlo ki vo still dominant h ya nhi
    //     }else{
    //         if(max*2>(i+1)){
    //             prefix[i]=elem;
    //         }else{
    //             prefix[i]=-1;
    //         }
    //     }
    // }
    // // now same chiz ko reverse se apply kro
    // HashMap<Integer,Integer> map1=new HashMap<>();
    // int suffix[]=new int[n];
    // max=Integer.MIN_VALUE;
    // elem=0;
    // for(int i=n-1;i>=0;i--){
    //     map1.put(nums.get(i),map1.getOrDefault(nums.get(i),0)+1);
    //     int x=map1.get(nums.get(i));
    //     if(x>max){
    //         max=x;
    //         if(x*2>(n-i)){
    //             elem=nums.get(i);
    //             suffix[i]=elem;
    //         }
    //     }else{
    //         if(max*2>(n-i)){
    //             suffix[i]=elem;
    //         }else{
    //             suffix[i]=-2;
    //         }
    //     }
    // }
    // for(int i=0;i<n-1;i++){
    //     if(prefix[i]==suffix[i+1]){
    //         //System.out.println(nums.get(i)+" "+nums.get(i+1));
    //         return i;
    //     }
    // }
    // return -1;
    }
}