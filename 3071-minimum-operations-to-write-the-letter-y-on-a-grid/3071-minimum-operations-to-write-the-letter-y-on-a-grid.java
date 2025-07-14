class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int center = n / 2;

        int totalY = 0;
        int nonTotalY = 0;

        int[] freqY = new int[3];
        int[] nonfreqY = new int[3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isOnY(i, j, center, n)){
                    totalY++;
                    freqY[grid[i][j]]++;
                } else{
                    nonTotalY++;
                    nonfreqY[grid[i][j]]++;
                }
            }
        }

        int minOP = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3;j++){
                if(i == j) continue;

                int Ycomb = totalY - freqY[i];
                int nonYcomb = nonTotalY - nonfreqY[j];

                minOP = Math.min(minOP, Ycomb + nonYcomb);
            }
        }

        return minOP;
    }

    private boolean isOnY(int r, int c, int center, int n){
        return (r <= center && r == c) || (r <= center && c == n-1-r) || (r > center && c == center);
    }
}

//TC: O(n ^ 2)
//SC: O(1)