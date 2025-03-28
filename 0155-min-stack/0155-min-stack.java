class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        if(minStack.peek() == top){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// Time Complexity: O(1) for all stack operations
// Space Complexity: O(n) where n is number of elements in stack

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */