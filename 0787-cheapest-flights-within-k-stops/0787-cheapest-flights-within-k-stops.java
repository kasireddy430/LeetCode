class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0, 0}); // {node, cost, stops}

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], cost = curr[1], stops = curr[2];

            if (stops > k) continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0], price = neighbor[1];

                if (cost + price < minCost[nextNode]) {
                    minCost[nextNode] = cost + price;
                    q.offer(new int[] {nextNode, minCost[nextNode], stops + 1});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}