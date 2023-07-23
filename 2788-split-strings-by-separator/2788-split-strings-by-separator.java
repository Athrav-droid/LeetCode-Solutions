class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for(String s : words){
            String[] temp = s.split("["+separator+"]");
            for(int i = 0; i < temp.length; i++){
                if(temp[i].length() > 0) ans.add(temp[i]);
            }
        }
        return ans;
    }
}