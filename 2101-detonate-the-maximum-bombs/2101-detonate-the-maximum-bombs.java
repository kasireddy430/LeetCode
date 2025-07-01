class Solution {
    public int maximumDetonation(int[][] bombs) {
        // Max number of bombs detonated
        int max = 0;

        // Detanote each bomb, and track number of bombs detonated
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, bfs(i, bombs));
        }
        
        return max;
    }

    private int bfs(int k, int[][] bombs) {
        int count = 1; // number of detonated bombs;

        int n = bombs.length; // number of bombs
        
        // Track the bombs that have been detonated
        boolean[] visited = new boolean[n];
        visited[k] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < n; j++) {
                if (!visited[j] && isInRange(bombs[i], bombs[j])) {
                    queue.offer(j);
                    visited[j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    // check if bomb2 is in range to be detonated by bomb1
    public boolean isInRange(int[] bomb1, int[] bomb2) {
        long dx = bomb1[0] - bomb2[0];
        long dy = bomb1[1] - bomb2[1];
        long r = bomb1[2];
        
        return dx*dx + dy*dy <= r*r; 
    }
}