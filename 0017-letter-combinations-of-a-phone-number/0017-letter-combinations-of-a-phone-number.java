class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        HashMap<Character,String> combinations = new HashMap<>();
        combinations.put('2', "abc");
        combinations.put('3', "def");
        combinations.put('4', "ghi");
        combinations.put('5', "jkl");
        combinations.put('6', "mno");
        combinations.put('7', "pqrs");
        combinations.put('8', "tuv");
        combinations.put('9', "wxyz");
        // if(digits.length() == 1){
        //     String helper = combinations.get(digits);
        //     for(int i=0;i<helper.length();i++){
        //         ans.add(helper.charAt(i).toString());
        //     }
        // }
        String temp = "";
        helper(0,temp,digits,ans,combinations);
        return ans;
    }
    public void helper(int index, String temp, String digits, List<String> ans, HashMap<Character,String> combinations){
        if(index == digits.length()){
            ans.add(temp);
            return;
        }
        char digit = digits.charAt(index);
        String get = combinations.get(digit);

        for(int i=0;i<get.length();i++){
            char c = get.charAt(i);
            temp += c; //including character
            helper(index+1,temp,digits,ans,combinations);
            temp = temp.substring(0,temp.length()-1); //excluding character
        }

    }
}