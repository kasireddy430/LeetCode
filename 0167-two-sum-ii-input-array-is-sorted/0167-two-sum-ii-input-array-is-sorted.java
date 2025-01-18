class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Initilize two pointers, one at the start and one at the end
        int left = 0, right = numbers.length - 1;

        //Iterate until both the pointers meet
        while(left < right){
            //Calculate the sum of numbers at both the pointers
            int currentSum = numbers[left] + numbers[right];

            //Check if current sum is smaller than the target value
            if(currentSum < target){
                //if so move the pointer forward
                left++;
            } //Check if current sum is greater than the target value 
            else if(currentSum > target) {
                //If so decrement the right pointer
                right--;
            } else {
                //If current sum matches the target value return the indices position
                return new int[]{left + 1, right + 1};
            }
        }

        //If no valid pair is found return an empty array
        return new int[]{};
    }
}