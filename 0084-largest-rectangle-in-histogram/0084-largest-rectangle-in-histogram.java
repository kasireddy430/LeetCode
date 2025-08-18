class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;

        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                longest = Math.max(longest, height * width);
            }
            stack.push(i);
        }
        return longest;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)