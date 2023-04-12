class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        String[] p = path.split("/");

        for(String curr : p){
            if(!s.isEmpty() && curr.equals("..")) s.pop();
            else if(!curr.equals("") && !curr.equals(".") && !curr.equals("..")) s.push(curr);
        }
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()) ans.insert(0, s.pop()).insert(0, "/");
        return ans.toString();
    }
}