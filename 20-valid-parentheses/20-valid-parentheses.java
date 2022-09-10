class Solution {
    public boolean isValid(String s) { 
        //approach if we not consider second case: open brackets must be closed in the correct order
        //(40 41) [91 93] {123 125}
        // if(s==null||s.length()%2!=0){
        //     return false;
        // }
        // int[] arr = new int[3];
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)==40){
        //         arr[0]++;
        //     }
        //     if(s.charAt(i)==41){
        //         arr[0]--;
        //     }
        //     if(s.charAt(i)==91){
        //         arr[1]++;
        //     }
        //     if(s.charAt(i)==93){
        //         arr[1]--;
        //     }
        //     if(s.charAt(i)==123){
        //         arr[2]++;
        //     }
        //     if(s.charAt(i)==125){
        //         arr[2]--;
        //     }
        // }
        // for(int val: arr){
        //     if(val!=0){
        //         return false;
        //     }
        // }
        // return true;
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
        // my code idk why it doesn't work for second test case
        // Stack<Character> stack = new Stack<>();
        // for(char c: s.toCharArray()){
        //     if(c == '(' || c == '[' || c == '{' ){
        //         stack.push(c);
        //     }else if(stack.isEmpty()){
        //         return false;
        //     }else{
        //         char top = stack.peek();
        //         if((c == ')' && top == '(') ||
        //            (c == ']' && top == '[') ||
        //            (c == '{' && top == '}')){
        //             stack.pop();
        //         }else{
        //             return false;
        //         }
        //     }
        // }
        // return stack.isEmpty();
    }
}