class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            if(c == ')'){
                if(stack.size() == 1){
                    stack.pop();
                    stack.push(i);
                }else{
                    stack.pop();
                    ans = Math.max(ans,i - stack.peek());
                }
            }
        }
        return ans;
    }
}