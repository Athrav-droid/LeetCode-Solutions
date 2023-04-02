class Solution {
    public String frequencySort(String s) {
        // List<Character> ans = new ArrayList<>();
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //     char c = s.charAt(i);
        //     ans.add(c);
        //     map.put(c, map.getOrDefault(c, 1) + 1);
        // }
        // Collections.sort(ans, (a, b) -> map.get(a) - map.get(b));
        // return ans.toString();
        
        
        //string builder for ans
        StringBuilder ans = new StringBuilder();
        // to count the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        // to sort the character based on frequency in descending order
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        //adding every key value set in the queue
        pq.addAll(map.entrySet());
        //popping every element and adding characters based on frequency in the ans
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curr = pq.poll();
            int val = curr.getValue();
            while(val > 0){
                ans.append(curr.getKey());
                val--;
            }
        }
        return ans.toString();
    }
}