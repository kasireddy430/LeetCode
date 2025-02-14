class Solution {
    public int[] plusOne(int[] digits) {
        //Calculate length of input array
        int n = digits.length;

        //Iterate over input array
        for(int i = n - 1; i >= 0; i--){
            //Check if the digit is less than 9
            if(digits[i] < 9){
                //If so increment the current digit and return digits array
                digits[i]++;
                return digits;
            }
            //If digit greater than 9, update the digit with 0
            digits[i] = 0;
        }

        //If we exit the loop, it means all digits are 9
        //create an array with extra space for handling this edge case scenario
        int[] result = new int[n + 1];
        result[0] = 1; //make first digit 1, rest all digits are 0 by default
        return result;
    }        
}

//Time Complexity: O(n)
//Space Complexity: O(1) and O(n) contributed by result array when all the digits are 1.
