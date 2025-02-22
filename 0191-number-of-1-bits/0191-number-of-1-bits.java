class Solution {
    public int hammingWeight(int n) {
        //Initialize a variable to count 1's in binary representation of input number
        int count = 0;
        //Iterate until n is non-zero
        while(n > 0){
            n = n & (n - 1); //Remove rightmost set bit(1's)
            count++;
        }
        //return number of 1 bit's in input number
        return count;
    }
}

//Time Complexity: O(k), where k is the number of 1 bits in n.
//Space Complexity: O(1)