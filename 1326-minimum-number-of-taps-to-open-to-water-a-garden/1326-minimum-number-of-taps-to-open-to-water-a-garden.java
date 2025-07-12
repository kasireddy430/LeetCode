class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];

        // Convert ranges to "jumps" like Jump Game II
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right - left);
        }

        int res = 0;
        int l = 0, r = 0;

        while (r < n) {
            int farthest = 0;

            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + maxReach[i]);
            }

            if (farthest == r) return -1; // stuck

            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }
}
