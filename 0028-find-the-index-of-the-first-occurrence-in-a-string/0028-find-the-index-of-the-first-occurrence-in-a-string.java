class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle); // working well :- The inbuilt indexOf(string) will return the first occurence of pattern in the main string. If the pattern is not present then it will return -1.
        if(needle.length() > haystack.length()) return -1;
        //Z-Algorithm is also one of best Approach O(m+n) T.C
        //Brute Force ... thoda logic idhr udhr horha h
        // for(int i=0;i<haystack.length();i++){
        //     int k=0;
        //     if(haystack.charAt(i) == needle.charAt(k)){
        //         int j=i;k++;j++;
        //         for(int l=k;l<needle.length();l++){
        //             if(haystack.charAt(j) != needle.charAt(k)) break;
                    
        //         }
        //     }
        // }
        // return -1;

        //Sliding Window Approach
        int h = haystack.length(), n = needle.length();
        int i=0,j=0;
        while(j<h){
            if((j-i+1) < n) j++;
            else{
                if(haystack.substring(i,j+1).equals(needle)) return i;
                i++;j++;
            }
        }
        return -1;
    }
}