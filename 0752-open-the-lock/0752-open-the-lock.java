class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> visited = new HashSet<>();
        for(String s : deadends) visited.add(s);

        if(visited.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        int ans = 0;

        visited.add("0000");
        q.add("0000");

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(target)) return ans;
                for(int i = 0; i < 4; i++){
                    char c = curr.charAt(i);
                    // since we can go both up and down, rotating dial clockwise or anticlockwise!!
                    // the - 0 converts the character to an int so math can be performed, once the numbers are added 
                    // they get converted back to a string!
                    String up = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
                    String down = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);
                    if(!visited.contains(up)){
                        q.add(up);
                        visited.add(up);
                    }
                    if(!visited.contains(down)){
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}