public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //Initialize a variable to store result
        int res = 0;

        //Iterate through all 32 bits of input integer
        for(int i = 0; i < 32; i++){
            int bit = (n >> i) & 1; //Extract ith bit from input integer
            res += (bit << (31 - i)); //Place the extracted bit and place it int's reversed position
        }
        //return reverse bits of the input integer
        return res;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)