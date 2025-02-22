class Solution {
    public int[] countBits(int n) {
        //Initialize an array to store result array consisting of bits count
        int[] ans = new int[n + 1];

        //Iterate through each number from 1 -> n
        for(int i = 1; i<= n; i++){
            //ans[i>>1] gives the count of 1's in i/2
            //(i&1) checks for the least significant digit
            ans[i] = ans[i>>1] + (i&1);
        }

        return ans;//return final array
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)