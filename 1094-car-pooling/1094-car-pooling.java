class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int i : diff) {
            sum += i;
            if (sum > capacity) {
                return false;
            }
        }
        return true;     
    }
}