class Solution {
    public int search(int[] nums, int target) {
        //Initilize pointers at the start and end of input array
        int left = 0, right = nums.length - 1;

        while(left <= right){
            //Calculate middle index
            int mid = left + (right - left)/2;

            //Check if target is found. If so return it's index
            if(nums[mid] == target){
                return mid;
            }

            //Check if the left subarray is sorted
            if(nums[left] <= nums[mid]){
                //Check if the target element could be part of the right subarray
                if(target < nums[left] || target > nums[mid]){
                    //If so move the left pointer
                    left = mid + 1;
                } else{
                    //If so move the right pointer
                    right = mid - 1;
                }
            } 
            //this block executes when right subarray is sorted
            else {
                //Check if the target element could be part of the left subarray
                if(target > nums[right] || target < nums[mid]){
                    //If so move the right pointer
                    right = mid - 1;
                } else{
                    //If so move the left pointer
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

//Time Complexity: O(log n)
//Space Complexity: O(1)