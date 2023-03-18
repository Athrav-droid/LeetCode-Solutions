class BrowserHistory {
    private Stack<String> sb, sf;
    private String curr;

    public BrowserHistory(String homepage) {
        sb = new Stack<String>();
        sf = new Stack<String>();
        curr = homepage;
    }
    
    public void visit(String url) {
        sb.push(curr);
        curr = url;
        sf = new Stack<String>();
    }
    
    public String back(int steps) {
        while(steps > 0 && !sb.isEmpty()){
            sf.push(curr);
            curr = sb.pop();
            steps--;
        }
        return curr;
    }
    
    public String forward(int steps) {
        while(steps > 0 && !sf.isEmpty()){
            sb.push(curr);
            curr = sf.pop();
            steps--;
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */