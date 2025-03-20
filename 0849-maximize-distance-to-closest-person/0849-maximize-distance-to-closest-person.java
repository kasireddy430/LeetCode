class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = -1;
        int max = 1;
        int r = 0;
        for (r = 0 ; r < seats.length; r++) {
            if (seats[r] == 1) {
                if (l == -1) max = r;
                max = Math.max(max, (r - l) / 2);
                l = r;
            }
        }
        return Math.max(max, r - l - 1);
    }
}