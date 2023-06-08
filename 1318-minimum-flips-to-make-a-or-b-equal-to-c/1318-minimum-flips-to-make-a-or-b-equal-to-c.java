class Solution {
    public int minFlips(int a, int b, int c) {
        // int answer = 0;
        // while (a != 0 | b != 0 | c != 0) {
        //     if ((c & 1) == 1) {
        //         if ((a & 1) == 0 && (b & 1) == 0) {
        //             answer++;
        //         }
        //     } else {
        //         answer += (a & 1) + (b & 1);
        //     }
            
        //     a >>= 1;
        //     b >>= 1;
        //     c >>= 1;
        // }
        
        // return answer;

        int ans = 0;
        for(int i = 0; i < 32; i++){
            boolean ai = false, bi = false, ci = false;
            if((a & (1 << i)) > 0) ai = true;
            if((b & (1 << i)) > 0) bi = true;
            if((c & (1 << i)) > 0) ci = true;

            if(ci){
                if(!ai && !bi) ans++;
            }else{
                if(ai && bi) ans+=2;
                else if(ai || bi) ans += 1;
            }
        }
        return ans;
    }
}