class Solution {
    // public String predictPartyVictory(String senate) {
    //     int dcount = 0, rcount = 0, dban = 0, rban = 0;
    //     int n = senate.length();
    //     Queue<Character> q = new LinkedList<>();
    //     for(char c : senate.toCharArray()){
    //         if(c == 'D') dcount++;
    //         else rcount++;
    //         q.offer(c);
    //     }
    //     while(dcount > 0 && rcount > 0){
    //         char curr = q.poll();
    //         if(curr == 'D'){
    //             if(dban > 0){
    //                 dban--;
    //                 dcount--;
    //             }else{
    //                 rban++;
    //                 q.offer(curr);
    //             }
    //         }else{
    //             if(rban > 0){
    //                 rban--;
    //                 rcount--;
    //             }else{
    //                 dban++;
    //                 q.offer(curr);
    //             }
    //         }
    //     }
    //     return rcount > 0 ? "Radiant" : "Dire";
    // }
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }
        while(!r.isEmpty() && !d.isEmpty()){
            if(r.peek() < d.peek()){
                d.poll();
                r.offer(r.peek() + n);
                r.poll();
            }else{
                r.poll();
                d.offer(d.peek() + n);
                d.poll();
            }
        }
        if(r.isEmpty()) return "Dire";
        else return "Radiant";
    }
}