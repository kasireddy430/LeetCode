class Solution {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int length = count.length;
        int[] result = new int[length];

        //If we upgrade k servers then we sell count[i] - k servers 
        //and add the initial money to the servers we are selling
        //(count[i] - k) * sell[i] + money[i] >= k * upgrade[i]
        for(int i = 0; i < length; i++){
            int den = upgrade[i] + sell[i];

            double k = (double) count[i] * sell[i]/den + (double) money[i]/den;

            result[i] = Math.min(count[i], (int)k);
        }
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)