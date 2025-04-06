class MaxStack {

    private Stack<int[]> stack;
    private Queue<int[]> queue;
    private Set<Integer> removed;
    private int counter;

    public MaxStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
        counter = 0;
    }

    public void push(int x) {
        stack.push(new int[]{x, counter});
        queue.offer(new int[]{x, counter});
        counter++;
    }

    public int pop() {
        while(removed.contains(stack.peek()[1])){
            stack.pop();
        }

        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        while(removed.contains(stack.peek()[1])){
            stack.pop();
        }

        return stack.peek()[0];
    }

    public int peekMax() {
        while(removed.contains(queue.peek()[1])){
            queue.poll();
        }

        return queue.peek()[0];       
    }

    public int popMax() {
        while(removed.contains(queue.peek()[1])){
            queue.poll();
        }

        int[] max = queue.poll();
        removed.add(max[1]);
        return max[0];  
    }
}


/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */