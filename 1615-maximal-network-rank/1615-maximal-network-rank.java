class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n]; 
        boolean[][] connected = new boolean[n][n]; 

        // Step 1: Build degrees and connections
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            degree[a]++;
            degree[b]++;
            connected[a][b] = true;
            connected[b][a] = true;
        }

        int maxRank = 0;

        // Step 2: Try all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];
                if (connected[i][j]) {
                    rank--; // avoid double-counting
                }
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
