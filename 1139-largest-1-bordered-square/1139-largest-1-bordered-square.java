class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n], top = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    top[i][j] = grid[i][j];
                } else {
                    top[i][j] = grid[i][j] == 0? 0 : top[i-1][j] + 1;
                }
                if (j == 0) {
                    left[i][j] = grid[i][j];
                } else {
                    left[i][j] = grid[i][j] == 0? 0 : left[i][j-1] + 1;
                }
                for (int l = Math.min(top[i][j], left[i][j]); l >= 1; l--) {
				// 已知下面的边和右侧边合法，看上边和左侧边是否合法
                    if (left[i-l+1][j] >= l && top[i][j-l+1] >= l) {
                        res = Math.max(res, l * l);
                        break;
                    }
                }
            }
        }
        return res;
    }
}