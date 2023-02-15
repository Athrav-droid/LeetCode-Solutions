class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<tokens.length;i++){
            String t = tokens[i];
            if( t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                if(t.equals("+")) stack.push(first + second);
                else if(t.equals("-")) stack.push(first - second);
                else if(t.equals("*")) stack.push(first * second);
                else stack.push(first / second);
            }else{
                int a = Integer.parseInt(tokens[i]);
                stack.push(a);
            }
        }
        return stack.pop();
    }
}