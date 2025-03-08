class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        if(nums.length == 0){
            return quadruplets;
        }

        Arrays.sort(nums);//sort the input array for handling duplicates
        int length = nums.length;

        for(int i = 0; i < length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;//skip same element to avoid duplicates
            }
            for(int j = i + 1; j < length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;//skip same element to avoid duplicate quadruplets
                }
                searchQuads(nums, target, i, j, quadruplets);//use two-pointer approach to look for quadruplets
            }
        }
        return quadruplets;
    }

    private void searchQuads(int[] nums, int target, int first, int second, List<List<Integer>> quadruplets){
        //Initialize two pointers
        int left = second + 1;
        int right = nums.length - 1;

        //Iterate until both pointers meet
        while(left < right){
            //to avoid potential overflow
            long currentSum = (long)nums[first] + nums[second] + nums[left] + nums[right];

            //if currentSum equals target add values to quadruplets
            if(currentSum == target){
                quadruplets.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));

                //Move pointers by 1-step
                left++;
                right--;

                while(left < right && nums[left] == nums[left - 1]){
                    left++;//Move pointer if same element found to avoid suplicate quadruplets
                }

                while(left < right && nums[right] == nums[right + 1]){
                    right--;//Move pointer if same element found to avoid suplicate quadruplets
                }
            }//if current Sum is less than target, move the left pointer
            else if(currentSum < target){
                left++;
            }//if current Sum is greater than target, move the right pointer
            else{
                right--;
            }
        }
    }
}

//Time Complexity: O(n ^ 3)
//Space Complexity: O(n ^ 2) contributed by quadruplets