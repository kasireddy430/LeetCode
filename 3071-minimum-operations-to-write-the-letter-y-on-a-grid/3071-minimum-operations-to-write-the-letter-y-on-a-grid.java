class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int m = n / 2;
        int totalY = m + n;
        int total = n * n;
        int totalNonY = total - totalY;

        int[] countY = new int[3];
        int[] countNonY = new int[3];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // in Y if
                //  • on the "top-left → center" diagonal, or
                //  • on the "top-right → center" diagonal, or
                //  • on the "center → bottom" vertical
                boolean inY = (r <= m && (c == r || c == (n-1-r)))
                           || (r >  m && c == m);

                if (inY) countY[grid[r][c]]++;
                else countNonY[grid[r][c]]++;
            }
        }

        // try all pairs (a,b) with a != b
        int ans = Integer.MAX_VALUE;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (a == b) continue;
                // repaint all Y-cells not already 'a', plus
                // all nonY-cells not already 'b'
                int ops = (totalY    - countY   [a])
                        + (totalNonY - countNonY[b]);
                ans = Math.min(ans, ops);
            }
        }
        return ans;
    }
}