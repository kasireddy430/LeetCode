class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int targetSum = target - nums[i];

            if(values.containsKey(targetSum)){
                return new int[]{values.get(targetSum), i};
            }
            values.put(nums[i], i);
        }
        return new int[]{};
    }
}