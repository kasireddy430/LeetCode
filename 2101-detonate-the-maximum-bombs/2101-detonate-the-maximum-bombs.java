class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (j != i && dx * dx + dy * dy <= r * r) {
                    g[i].add(j); // i 可以引爆 j
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n && ans < n; i++) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(g, vis, i));
        }
        return ans;
    }

    private int dfs(List<Integer>[] g, boolean[] vis, int x) {
        vis[x] = true;
        int cnt = 1;
        for (int y : g[x]) {
            if (!vis[y]) {
                cnt += dfs(g, vis, y);
            }
        }
        return cnt;
    }
}