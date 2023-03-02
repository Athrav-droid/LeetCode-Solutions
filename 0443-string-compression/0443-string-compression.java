class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int j = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            int count = 1;
            while( i + count < chars.length && c == chars[i+count]){
                count++;
            }
            chars[j++] = c;
            if(count > 1){
                for(char d : Integer.toString(count).toCharArray()){
                    chars[j++] = d;
                }
            }
            i += count-1;
        }
        return j;
    }
}