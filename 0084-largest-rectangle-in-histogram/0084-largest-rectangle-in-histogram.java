class Solution {
    public int largestRectangleArea(int[] heights) {
        int largest = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - (stack.peek() + 1);
                largest = Math.max(largest, height * width);
            }
            stack.push(i);
        }
        return largest;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)