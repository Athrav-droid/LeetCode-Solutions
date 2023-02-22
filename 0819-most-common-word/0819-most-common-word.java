class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lowerPara = paragraph.toLowerCase();
        // System.out.println(lowerPara);
        String paraArr[] = lowerPara.split("[ !?',;.]");
        // for(String s: paraArr){
        //     System.out.println(s);
        // }
        HashMap<String, Integer> helper = new HashMap<>();
        List<String> ban = new ArrayList<>();
        for(String s : banned) ban.add(s.toLowerCase());
        for(String s : paraArr){
            if(helper.containsKey(s) || !ban.contains(s)){
                if(helper.containsKey(s)) helper.put(s,helper.get(s) + 1);
                else helper.put(s, 1);
            }
        }
        String maxKey = "";
        int max = Integer.MIN_VALUE;
        if(helper.containsKey("")) helper.remove("");
        if(helper.containsKey(" ")) helper.remove(" ");
        for(String key : helper.keySet()){
            // System.out.println(key);
            // System.out.println(helper.get(key));
            if(helper.get(key) > max){
                
                max = helper.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
}