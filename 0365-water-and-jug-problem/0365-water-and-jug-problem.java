class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
   // If target is greater than the combined capacity of both jugs return false
        if (target > x + y) return false;
   // If target is 0, we can always measure it by doing nothing
        if (target == 0) return true;
   // Calculate the GCD of x and y
        int gcd = gcd(x, y);
        return target % gcd == 0;
    }
     private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}