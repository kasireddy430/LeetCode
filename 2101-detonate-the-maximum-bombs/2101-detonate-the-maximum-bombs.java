public class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                long d = (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);

                if (d <= (long) r1 * r1) {
                    adj[i].add(j);
                }
                if (d <= (long) r2 * r2) {
                    adj[j].add(i);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, new HashSet<>(), adj));
        }
        return res;
    }

    private int dfs(int i, Set<Integer> visit, List<Integer>[] adj) {
        if (!visit.add(i)) return 0;
        for (int nei : adj[i]) {
            dfs(nei, visit, adj);
        }
        return visit.size();
    }
}