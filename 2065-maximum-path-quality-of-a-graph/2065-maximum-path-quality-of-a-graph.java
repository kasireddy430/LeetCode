public class Solution {
    private int ans;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build graph
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        ans = 0;
        dfs(0, visited, values[0], maxTime, values, graph);
        return ans;
    }

    private void dfs(int node, boolean[] visited, int gain, int timeLeft, int[] values, List<int[]>[] graph) {
        if (node == 0) {
            ans = Math.max(ans, gain);
        }

        for (int[] edge : graph[node]) {
            int nei = edge[0], w = edge[1];
            if (w <= timeLeft) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dfs(nei, visited, gain + values[nei], timeLeft - w, values, graph);
                    visited[nei] = false; // backtrack
                } else {
                    dfs(nei, visited, gain, timeLeft - w, values, graph);
                }
            }
        }
    }
}