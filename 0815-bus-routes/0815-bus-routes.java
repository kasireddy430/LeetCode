class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int maxStation = 0;
        Map<Integer, List<Integer>> stationToBus = new HashMap<>();

        int buses = routes.length;

        for (int i = 0; i < buses; i++) {
            for (int station : routes[i]) {
                stationToBus.computeIfAbsent(station, k -> new ArrayList<>()).add(i);
                maxStation = Math.max(maxStation, station);
            }
        }


        if (!stationToBus.containsKey(source) || !stationToBus.containsKey(target)) {
            return -1;
        }
        int busOffset = maxStation + 1;
        int totalNodes = busOffset + buses;
        //System.out.println(busOffset + " " + totalNodes);
        int[] dist = new int[totalNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        Deque<Integer> q = new ArrayDeque<>();

        q.add(source);

        while (!q.isEmpty()) {
            int node = q.poll();
            //System.out.println(node);
            if (node == target) {
                return dist[target];
            }
            if (node < busOffset) {
                for (int bus : stationToBus.get(node)) {
                    int busNode = busOffset + bus;
                    if (dist[busNode] > dist[node] + 1) {
                        dist[busNode] = dist[node] + 1;
                        q.addLast(busNode);
                    }
                }
            } else {
                int bus = node - busOffset;

                for (int station : routes[bus]) {
                    if (dist[station] > dist[node]) {
                        dist[station] = dist[node];
                        q.addFirst(station);
                    }
                }
            }
        }
        return -1;
    }
}