class Solution {
    public int missingNumber(int[] nums) {
        //Calculate length of input array
        int n = nums.length;
        int xorr = n;//start xor with n, since missing number is in range [0, n]

        //XOR with indices and array elements
        for(int i = 0; i < n; i++){
            xorr ^= i ^ nums[i];
        }
        //return missing number
        return xorr;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)