class Solution {
    public int largestRectangleArea(int[] heights) {
        //stack tracks the histogram bars indices
        Stack<Integer> stack = new Stack<>();
        int largest = 0;//stores largest rectangle in histogram
        int length = heights.length;

        //Iterate through input array
        for(int i = 0; i <= length; i++){
            //for better handling of last bar
            int currentHeight = (i == length) ? 0 : heights[i];

            //If current bar height is less than topmost element in stack
            //calculate the height of the highest bar
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty()? i : i - (stack.peek() + 1);
                largest = Math.max(largest, height * width);
            }

            //if current height is greater, add it to stack
            stack.push(i);
        }
        return largest;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)