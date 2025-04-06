class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target > x + y){
            return false;
        }

        if(target == 0){
            return true;
        }

        int hcf = gcd(x, y);
        return target % hcf == 0;
    }

    private static int gcd(int a, int b) {
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}

//Time complexity: O(log(min(x, y)))
//Space Complexity: O(1)