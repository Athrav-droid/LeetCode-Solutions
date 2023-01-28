class Solution {
    public int romanToInt(String s) {
        int ans = 0, curr=0, prev=0;
        for (int j = s.length() - 1; j >= 0; j--) { //piche se string ko check krna 
        switch (s.charAt(j)) {
            case 'M' -> curr = 1000;
            case 'D' -> curr = 500;
            case 'C' -> curr = 100;
            case 'L' -> curr = 50;
            case 'X' -> curr = 10;
            case 'V' -> curr = 5;
            case 'I' -> curr = 1;
        }
        if(prev > curr) ans-=curr;
        else ans+=curr;
        prev = curr;
        }
        return ans;
    }
}