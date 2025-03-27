class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0;
        long missing = 1;
        int patches = 0;

        while(missing <= n){
            if(i < nums.length && nums[i] <= missing){
                missing += nums[i];
                i++;
            } else{
                missing += missing;
                patches++;
            }
        }
        return patches;
    }
}

//Time Complexity: O(n)
//Space COmplexity: O(1)