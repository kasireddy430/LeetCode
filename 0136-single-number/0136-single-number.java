class Solution {
    public int singleNumber(int[] nums) {
        //Initialize a variable to store the single number
        int result = 0;

        //iterate over input array
        for(int num : nums){
            //Use XOR operation to find single number
            result ^=  num;
        }
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)