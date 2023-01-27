class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();  // use of stack filo
        for(char c: s.toCharArray()){   // converted string into char array
            if(c == '{' || c == '[' || c == '('){  // check if the bracket is opening or not
                stack.push(c); // if yes then push
            }else if(stack.isEmpty()){  //if stack is empty then return false
                return false;
            }else{
                char top = stack.peek();  // stack top element stored and then check for all three conditons, if condition satisfied then pop else false
                if((c == '}' && top == '{') ||
                   (c == ']' && top == '[') ||
                   (c == ')' && top == '(')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}