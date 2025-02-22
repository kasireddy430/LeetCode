class Solution {
    public int getSum(int a, int b) {
        //Iterate until there is no carry left 
        while(b != 0){
            int carry = (a & b) << 1; //calculate carry and shit it to next higher position
            a ^= b; //calculate regular binary addition without carry
            b = carry;//Carry needs to be used in next iteration
        }
        //return the sum of two numbers
        return a;
    }
}

//Time Complexity: O(1). The loop runs at most 32 times (since integers are 32 bits in Java). So the time complexity is constant.
//Space Complexity: O(1)