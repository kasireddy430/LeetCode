class Solution {
    public int findDuplicate(int[] nums) {
        //Initialize pointers at the starting index
        int slow = 0, fast = 0;

        while(true){
            //Move slow pointer by one step and fast by two steps
            slow = nums[slow];
            fast = nums[nums[fast]];

            //Check if both the pointers meet to check if a cycle exists
            if(slow == fast){
                break;
            }
        }

        //Initilize one more pointerat starting index
        int slow2 = 0;
        while(true){
            //Move both pointers by one-step
            slow2 = nums[slow2];
            slow = nums[slow];
            //Check if both pointers meet
            if(slow == slow2){
                return slow;
            }
        }
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)