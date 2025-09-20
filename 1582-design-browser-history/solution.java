class BrowserHistory {

    private Stack<String> forwardStack;
    private Stack<String> backwaStack;
    private String current;

    public BrowserHistory(String homepage) {
        backwaStack = new Stack<>();
        forwardStack = new Stack<>();
        this.current = homepage;

    }

    public void visit(String url) {
        //push the current to the backwaStack
        backwaStack.push(current);
        //set the current to the new URL
        current = url;
        //clear the forward stack
        forwardStack.clear();

    }

    public String back(int steps) {

        while (steps > 0 && !backwaStack.isEmpty()) {
            forwardStack.push(current);
            current = backwaStack.pop();
            steps--;
        }
        return current;

    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backwaStack.push(current);
            current = forwardStack.pop();
            steps --;
        }
        return current;

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
