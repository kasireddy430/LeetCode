class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Initilize a variable to store the result
        List<List<Integer>> triplets = new ArrayList<>();

        //Check if the input array is empty
        if(nums.length == 0){
            //If so return empty list
            return triplets;
        }

        //Sort the input array before retrieving the triplets satifying the underlying conditions
        Arrays.sort(nums);

        //Iterate over input array
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) //Skip duplicate values
                continue;
            searchTriplets(nums, -nums[i], i + 1, triplets);
        }

        return triplets;
    }

    private void searchTriplets(int[] nums, int target, int left, List<List<Integer>> triplets){
        int right = nums.length - 1;

        //Iterate until both pointers meet
        while(left < right){
            int currentSum = nums[left] + nums[right];

            //Check if a valid triplet os found
            if(currentSum == target){
                //if so add them to triplets list
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));

                //Move the pointers
                left++;
                right--;

                //skip the duplicate values tackled by the left pointer
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }

                //skip the duplicate values tackled by the right pointer
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            } else if(currentSum > target){
                right--;
            } else{
                left++;
            }
        }
    }
}

//Time Complexity: O(n^2)
//Space Complexity: O(n). Contributed by triplets