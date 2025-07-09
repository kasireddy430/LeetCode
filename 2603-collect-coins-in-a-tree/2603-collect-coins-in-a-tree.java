class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;

        // Build adjacency list
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        // Prune leaf nodes with no coins
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        while (!q.isEmpty()) {
            int u = q.poll();
            alive[u] = false;
            for (int v : tree[u]) {
                if (!alive[v]) continue;
                degree[v]--;
                if (degree[v] == 1 && coins[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Remove 2 outermost layers of leaves
        for (int round = 0; round < 2; round++) {
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (alive[i] && degree[i] == 1) {
                    leaves.add(i);
                }
            }
            for (int u : leaves) {
                alive[u] = false;
                for (int v : tree[u]) {
                    if (!alive[v]) continue;
                    degree[v]--;
                }
            }
        }

        // Count remaining edges
        int edgeCount = 0;
        for (int i = 0; i < n; ++i) {
            if (!alive[i]) continue;
            for (int j : tree[i]) {
                if (alive[j]) edgeCount++;
            }
        }

        return edgeCount;
    }
}
