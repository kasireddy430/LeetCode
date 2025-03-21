class Solution {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int[] result = new int[n];
        // upgrade k servers, sell count[i] - k servers
        // (count[i] - k) * sell[i] + money >= k * upgrade[i]
        // count[i] * sell[i] + money >= k (upgrade[i] + sell[i])
        for (int i = 0; i < n; i++) {
            double den = upgrade[i] + sell[i];
            double numerator = ((double) count[i] * sell[i] / den) + ((double) money[i] / den);
            result[i] = Math.min(count[i], (int) numerator);
        }
        return result;
    }
}