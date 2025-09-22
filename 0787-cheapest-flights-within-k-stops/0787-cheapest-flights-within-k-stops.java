class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0}); //(currentNode, totalCost, stops)

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0], cost = cur[1], stops = cur[2];

            if(stops > k){
                continue;
            }

            for(int[] nei: adj.get(node)){
                int neighbor = nei[0], price = nei[1];

                if(stops <= k && minCost[neighbor] > cost + price){
                    minCost[neighbor] = cost + price;
                    q.offer(new int[]{neighbor, minCost[neighbor], stops + 1});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}

//Time Complexity: O(n + E * k)
//Space Complexity: O(n + E)