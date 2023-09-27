class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int count = 1;
        while(temp.length() < b.length()) {
            temp += a;
            count++;
        }
        if(temp.contains(b)) return count;
        temp += a;
        if(temp.contains(b)) return count + 1;
        return -1;
    }
}