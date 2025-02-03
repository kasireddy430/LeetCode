class Solution {
    public int search(int[] nums, int target) {
        //initialize pointers at the start and end of input array
        int left = 0, right = nums.length - 1;

        //Iterate until both pointers meet
        while(left <= right){
            //Calculate the middle index of the input array
            int mid = left + (right - left)/2;
            //Check if target element is greater than the target
            if(nums[mid] < target){
                //if so move the left pointer to right half
                left = mid + 1;
            } else if(nums[mid] > target){
                //if target is smaller than mid element move right pointer
                right = mid - 1;
            } else{
                //This block executes when a target element is found
                return mid;
            }
        }
        return -1;
    }
}

//Time Complexity: O(log n)
//Space Complexity: O(1)