class MinStack {
    Stack<Integer> stack;
    Stack<Integer> history;
    public MinStack() {
        stack = new Stack<>();
        history = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(history.isEmpty() || history.peek() >= val) history.push(val);
    }
    
    public void pop() {
        int x = stack.pop();
        if(x == history.peek()) history.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return history.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */