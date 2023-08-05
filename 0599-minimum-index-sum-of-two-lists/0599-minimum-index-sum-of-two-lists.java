class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i]) && min > (map.get(list2[i]) + i)){
                min = map.get(list2[i]) + i;
            }
        }
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i]) && min == (map.get(list2[i]) + i)){
                ans.add(list2[i]);
            }
        }
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}