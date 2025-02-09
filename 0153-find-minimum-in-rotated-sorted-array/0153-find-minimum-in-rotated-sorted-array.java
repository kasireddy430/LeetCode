class Solution {
    public int findMin(int[] nums) {
        //Initialize pointers at start and end of input array
        int left = 0, right = nums.length - 1;

        //Iterate until both pointers meet
        while(left < right){
            //Calculate middle index
            int mid = left + (right - left)/2;

            //Check if the right subarray is sorted
            //If so mid could be in the left half
            if(nums[mid] <= nums[right]){
                //If so do BSA in left subarray
                right = mid;
            } else {
                //If not do BSA in right subarray
                left = mid + 1;
            }
        }

        //return the mimumum element in the input array
        return nums[left];
    }
}

//Time Complexity: O(log n)
//Space Complexity: O(1)