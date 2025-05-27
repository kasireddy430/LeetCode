class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for(int num : nums){
            int tmp = Math.max(rob2, num + rob1);
            rob1 = rob2;
            rob2 = tmp;
        }

        return rob2;
    }
}

//TC: O(n)
//SC: O(1)