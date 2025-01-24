class Solution {
    public int longestConsecutive(int[] nums) {
        //Check if input array is empty
        if(nums.length == 0){
            return 0;
        }

        //Create hashSet to store unique values from the input array
        Set<Integer> sequence = new HashSet<>();

        //Iterate over input array and add them to the hashSet
        for(int num : nums){
            sequence.add(num);
        }

        int max = 0;
        //Iterate over hashset
        for(int value : sequence){
            //Check if the current value is the starting point of the sequence
            if(!sequence.contains(value - 1)){
                //If so calculate the amount of maximum consequtive sequence of numbers
                int length = 1;
                while(sequence.contains(value + length)){
                    length++;
                }
                //update max wioth the longest consecutive sequence
                max = Math.max(max, length);
            }
        }
        return max;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)