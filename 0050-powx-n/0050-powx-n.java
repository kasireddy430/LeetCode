public class Solution {
    public double myPow(double x, int n) {
        if(x == 0)return 0;//If base is 0, return 0
        if(n == 0)return 1;//If exponent is zero, return 1

        double res = 1;
        //make exponent positive for handling the negative exponents
        long power = Math.abs((long)n);

        //Iterate until power reaches 0
        while(power > 0){
            //Check if exponent is odd or even
            if((power & 1) == 1){
                //If odd, multiply result by x
                res *= x;
            }
            //Square the base for next iteration
            x = x * x;
            //right shift exponent by 1(divide exponent by 2)
            power = power >> 1;
        }
        //If exponent is positive, return result
        //If not return it's reciprocal
        return n > 0? res:1/res;
    }
}

//Time Complexity: O(log n). since we halve the exponents at each step and do the same operations
//Space Complexity: O(1)