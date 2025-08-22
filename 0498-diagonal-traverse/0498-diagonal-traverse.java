class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        
        int idx = 0;
        
        for (int d = 0; d < m + n - 1; d++) {
            int row, col;
            
            if (d % 2 == 0) {
                // Up-right direction
                row = (d < m) ? d : m - 1;
                col = d - row;
                
                while (row >= 0 && col < n) {
                    res[idx++] = mat[row][col];
                    row--;
                    col++;
                }
            } else {
                // Down-left direction
                col = (d < n) ? d : n - 1;
                row = d - col;
                
                while (col >= 0 && row < m) {
                    res[idx++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}