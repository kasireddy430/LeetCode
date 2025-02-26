class Solution {
    public boolean canJump(int[] nums) {
        //Initilize goal at the last index of input array, which we need to reach
        int goal = nums.length - 1;

        //Iterate from last second element to first element of input array
        for(int i = nums.length - 1; i >= 0; i--){
            //Check if we can reach goal from current index
            if(i + nums[i] >= goal){
                goal = i;//If so, update the goal to current index which we need to reach in next iteration
            }
        }

        //If we moved goal to first index, then we can reach last index
        return goal == 0;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)