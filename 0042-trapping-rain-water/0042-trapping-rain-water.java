class Solution {
    public int trap(int[] height) {
        //Initialize pointers at the start and end of the input array
        int left = 0, right = height.length - 1;
        //Initialize variables to track leftmost maximum and rightmost maximum
        int leftMax = height[left], rightMax = height[right];
        int result = 0;

        //Iterate untill both the pointers meet
        while(left<right){
            //Check if height at left pointer is greater or not
            if(height[left] > height[right]){
                //If so, move right pointer and update rightmost maximum value
                right--;
                rightMax = Math.max(rightMax, height[right]);
                //update the result with amount water trapper between current height 
                //and the rightmost maximum value 
                result += rightMax - height[right];
            } else {
                //If not move left pointer and update leftmost maximum value
                left++;
                leftMax = Math.max(leftMax, height[left]);
                //update the result with amount water trapper between current height 
                //and the leftmost maximum value 
                result += leftMax - height[left];
            }
        }
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)