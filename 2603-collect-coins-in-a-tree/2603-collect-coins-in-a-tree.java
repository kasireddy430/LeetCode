class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;

        // Step 1: Build adjacency list and degree array
        List<List<Integer>> tree = new ArrayList<>();
        int[] degree = new int[n];

        // Initialize each list inside the outer list
        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // Step 2: Track which nodes are alive
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        // Step 3: Prune leaf nodes with no coins
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            alive[u] = false;

            for (int v : tree.get(u)) {
                if (!alive[v]) continue;

                degree[v]--;
                if (degree[v] == 1 && coins[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Step 4: Remove 2 layers of leaves
        for (int round = 0; round < 2; round++) {
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (alive[i] && degree[i] == 1) {
                    leaves.add(i);
                }
            }

            for (int u : leaves) {
                alive[u] = false;
                for (int v : tree.get(u)) {
                    if (!alive[v]) continue;
                    degree[v]--;
                }
            }
        }

        // Step 5: Count remaining edges
        int edgeCount = 0;
        for (int i = 0; i < n; ++i) {
            if (!alive[i]) continue;
            for (int j : tree.get(i)) {
                if (alive[j]) edgeCount++;
            }
        }

        return edgeCount;
    }
}
