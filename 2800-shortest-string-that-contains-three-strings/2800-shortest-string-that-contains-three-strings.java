class Solution {
    public String minimumString(String a, String b, String c) {
        List<String> allStrings = new ArrayList<>();
        allStrings.add(helper(a, b, c));
        allStrings.add(helper(a, c, b));
        allStrings.add(helper(b, c, a));
        allStrings.add(helper(b, a, c));
        allStrings.add(helper(c, a, b));
        allStrings.add(helper(c, b, a));
        String min = allStrings.get(0);
        for(int i = 0; i < allStrings.size(); i++){
            // if new string length is greater than no need to update
            if(allStrings.get(i).length() > min.length()) {
                continue;
            }
            // if lenght is smaller than update
            if(allStrings.get(i).length() < min.length()) {
                min = allStrings.get(i);
                continue;
            }
            // lexographical case:- if same then check lexographically
            if(allStrings.get(i).compareTo(min) < 0) {
                min = allStrings.get(i);
            }
        }
        return min;
    }

    public String helper(String a, String b, String c){
        String ab = mainHelper(a, b);
        return mainHelper(ab, c);
    }

    public String mainHelper(String a, String b){
        if(a.contains(b)) return a;
        int size = Math.min(a.length(), b.length());
        for(int i = size; i >= 0; i--){
            if(a.substring(a.length() - i).equals(b.substring(0, i))){
                return a + b.substring(i);
            }
        }
        return a + b;
    }
}