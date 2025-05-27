class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int one = 1;
        int two = 1;

        for(int i = 0; i < n-1; i++){
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)