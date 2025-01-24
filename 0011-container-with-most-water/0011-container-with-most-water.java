class Solution {
    public int maxArea(int[] height) {
        //Initialize pointers at the start and end of the input array
        int left = 0, right = height.length - 1;
        int result = 0;
        //Iterate until both the pointers meet
        while(left < right){
            //Calculate the area at current pointers position
            int area = Math.min(height[left], height[right]) * (right - left);
            //Update the maximum area
            result = Math.max(result, area);

            //Check if height at left pointer is greater than or equal to right pointer
            if(height[left] >= height[right]){
                //If so move the right pointer by one step
                right--;
            } else{
                //If not move the left pointer
                left++;
            }
        }
        //return maximum amount of water a container can store
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)