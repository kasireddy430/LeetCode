class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0; // No bus needed if already at the target

        // Step 1: Map bus stops to the list of buses that stop there
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(bus);
            }
        }

        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            return -1;
        }

        // Step 2: BFS Initialization
        int busCount = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        // Step 3: Start BFS from source stop
        q.add(source);
        visitedStops.add(source);

        while (!q.isEmpty()) {
            busCount++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int stop = q.poll();
                // Traverse all buses available from this stop
                for (int bus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus))
                        continue;
                    visitedBuses.add(bus);
                    // Traverse all stops this bus covers
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target)
                            return busCount;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.add(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}