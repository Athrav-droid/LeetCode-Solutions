class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> pu = new Stack<>();
        int po = 0;
        for(int i = 0; i < pushed.length; i++){
            pu.push(pushed[i]);
            while(!pu.isEmpty() && po < n && pu.peek() == popped[po]){
                pu.pop();
                po++;
            }
        }
        return po == n;
    }
}