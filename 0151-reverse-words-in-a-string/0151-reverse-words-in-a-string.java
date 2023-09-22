class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        s = s.trim();
        String[] helper = s.trim().split("\\s+");
        int len = helper.length;
        int i = 0, j = len - 1;
        while(i < j){
            String temp = helper[i];
            helper[i] = helper[j];
            helper[j] = temp;
            i++;j--;
        }
        // String ans = "";
        // for(String st : helper){
        //     ans = ans + st + " ";
        // }
        // return ans.trim();

        return String.join(" ", helper);
    }
}