class Solution {
    public int jump(int[] nums) {
        //Initialize a variable to track minimum number of jumps required to reach last index
        int res = 0;

        //Initilize left and right boundaries in current jump range
        int l = 0, r = 0;

        //Iterate until right boundary reaches or exceeds the last index
        while(r < nums.length - 1){
            //Initilize a variable to determine farthest reachable index in current jump range
            int farthest = 0;

            //Iterate over current jump range and find farthest reachable point
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            //Update left and right boundaries for next jump range
            l = r + 1;
            r = farthest;

            //Increment jump count
            res++;
        }
        //return minimum number of jumps needed to reach last index
        return res;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)