class Solution {
    public int minFlipsMonoIncr(String a) {
        //dry run krke dekho
        int count0 = 0, count1 = 0;
        for(char s: a.toCharArray()){
            if(s == '0') count0++;
            else count1++;
            count0 = Math.min(count0,count1);
        }
        return count0;
    }
}