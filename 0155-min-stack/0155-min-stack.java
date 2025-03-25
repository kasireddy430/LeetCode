class MinStack {

    private Stack<Integer> stack; // main stack to store values
    private Stack<Integer> minStack; // auxilary minStack to store minmum values

    //Initialize both the stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        // add the value to top of the stack
        stack.push(val);
        // Check if minStack has either no values or current value is less than the existing top value
        if(minStack.isEmpty() || val <= minStack.peek()){
            //If so add it to top of minStack
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        // Remove the top element from stack it the stack isn't empty
        int top = stack.pop();
        // Check if poped element is the minimum value
        if(top == minStack.peek()){
            //If so remove it from auxilary stack
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