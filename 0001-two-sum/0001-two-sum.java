class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Create a hashmap to store the integers from input array and their indices
        Map<Integer, Integer> values = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            //Calaculate the target sum
            int targetSum = target - nums[i];

            //Check if the target sum is part of the hash map
            if(values.containsKey(targetSum)){
                //If so we found the valid pair 
                return new int[]{values.get(targetSum), i};
            }
            //If not add it to the map
            values.put(nums[i], i);
        }
        //return empty array if no valid pair is found
        return new int[]{};
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)