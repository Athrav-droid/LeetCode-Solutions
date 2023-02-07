class Solution {
    public int totalFruit(int[] fruits) {
        // SOLUTION IF CONSECUTIVE ELEMENTS ARE NOT REQUIRED
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<fruits.length;i++){
        //     int curr = fruits[i];
        //     if(map.containsKey(curr)){
        //         map.put(curr,map.get(curr)+1);
        //     }else{
        //         map.put(curr,1);
        //     }
        // }
        // List<Integer> helper = new ArrayList<>(map.values());
        // int ans = 0;
        // Collections.sort(helper);
        // ans += helper.get(helper.size() -1) + helper.get(helper.size() -2);
        // return ans;
        
        // OPTIMISED BRUTE FORCE 
        // int maxPicked = 0;
        // for (int left = 0; left < fruits.length; ++left) {
        //     Set<Integer> basket = new HashSet<>();
        //     int right = left;
        //     while (right < fruits.length) {
        //         if (!basket.contains(fruits[right]) && basket.size() == 2)
        //             break;
        //         basket.add(fruits[right]);
        //         right++;
        //     }
        //     maxPicked = Math.max(maxPicked, right - left);
        // }
        // return maxPicked;
        
        // SLIDING WINDOW APPROACH
        HashMap<Integer,Integer> basket = new HashMap<>();
        int left = 0, right = 0;
        for(right =0; right < fruits.length ; ++right){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            if(basket.size() > 2){
                basket.put(fruits[left],basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]);
                }
                left++;
            }
        }
        return right - left;
    }
}