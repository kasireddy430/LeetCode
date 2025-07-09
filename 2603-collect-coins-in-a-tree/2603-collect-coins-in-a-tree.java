class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;

        // Step 1: Build the adjacency list using List instead of Set
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        // Step 2: Prune all leaf nodes that do not contain coins
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (tree[i].size() == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (tree[u].isEmpty()) continue;

            int v = tree[u].get(0); // only neighbor
            tree[u].remove((Integer) v);
            tree[v].remove((Integer) u);

            if (tree[v].size() == 1 && coins[v] == 0) {
                queue.offer(v);
            }
        }

        // Step 3: Remove two layers of leaves
        for (int k = 0; k < 2; ++k) {
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (tree[i].size() == 1) {
                    leaves.add(i);
                }
            }
            for (int u : leaves) {
                if (tree[u].isEmpty()) continue;
                int v = tree[u].get(0);
                tree[u].remove((Integer) v);
                tree[v].remove((Integer) u);
            }
        }

        // Step 4: Count remaining edges
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += tree[i].size();
        }

        return ans;
    }
}
