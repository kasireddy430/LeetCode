class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        //Find first decresing element from the end of input array
        int i = length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        //Find smallest element greater than first decreasing element
        // and swap both elements
        int j = length -1;

        if(i >= 0){
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            //swap i and j placed elements for next permutation
            swap(nums, i, j);
        }

        //reverse elements to rightside from i + 1 to obtain smallest lexicographical order
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i){
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)