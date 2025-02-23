class Solution {
    public int reverse(int x) {
        //Define constants for minimum and maximum integer values
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int res = 0;
        //Iterate through each digit of input number
        while(x != 0){
            int digit = x % 10; //Extract rightmost digit
            x /= 10; //Remove rightmost digit

            //Check for Overflow: if res is greater than MAX/10 then multiplying it with 10 will cause overflow
            //if res equals MAX/10 and the digit is greater than rightmost digit of MAX then overflow occurs
            if(res > MAX/10 || (res == MAX/10 && digit > MAX % 10)){
                return 0;
            }

            //Check for underflow: if res is less than MIN/10 then multiplying it with 10 will cause underflow
            //if res equals MAX/10 and the digit is less than rightmost digit of MAX then underflow occurs
            if(res < MIN/10 || (res < MIN/10 && digit < MIN % 10)){
                return 0;
            }

            //Update res by shifting the digits to left
            res = (res * 10) + digit;
        }

        //return the reversed integer
        return res;
    }
}

//Time Complexity: O(log x)
//Space Complexity: O(1)