class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int center = n/2;

        int[] yFreq = new int[3]; // Store frequency of 0, 1, and 2
        int[] nonYFreq = new int[3];
        int totalY = 0; // Total elements on Y.
        int totalNonY = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isOnY(n,center,i,j)) {
                    yFreq[grid[i][j]]++;
                    totalY++;
                } else {
                    nonYFreq[grid[i][j]]++;
                    totalNonY++;
                }
            }
        }

        // Now that we have freq of all, we can just try differetn combination of y and non-y between 0,1,2.
        int minOp = Integer.MAX_VALUE;
        for(int y = 0; y < 3; y++) {
            for(int nonY = 0; nonY < 3; nonY++) {
                if(y == nonY)
                    continue;
                int yModifyCost = totalY - yFreq[y]; //Cost of changing all items on Y to y
                int nonYModifyCost = totalNonY - nonYFreq[nonY]; //Cost of changing all items on NonY to nonY
                minOp = Math.min(minOp, yModifyCost + nonYModifyCost);
            }
        }
        return minOp;
    }

    public boolean isOnY(int n, int center, int r, int c) {
        return (r==c && r<=center ) || ( (r+c+1) == n && r<=center) || (r > center && c == center);
    }
}