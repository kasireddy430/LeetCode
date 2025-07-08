class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, cur = 0;
        int p2 = nums.length - 1;
        int tmp = 0;

        while(cur <= p2){
            if(nums[cur] == 0){
                tmp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            } else if(nums[cur] == 2){
                tmp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = tmp;
            } else cur++;
        }
    }
}

//TC: O(n)
//SC: O(1)