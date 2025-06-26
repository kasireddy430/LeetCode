class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        int busesCount = routes.length;
        for(int bus = 0; bus < busesCount; bus++){
            for(int stop : routes[bus]){
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(bus);
            }
        }

        if(!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)){
            return -1;
        }

        int buses = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);

        while(!q.isEmpty()){
            buses++;
            int size = q.size();

            for(int i = 0; i < size; i++){
                int curStop = q.poll();

                for(int bus : stopToBuses.getOrDefault(curStop, new ArrayList<>())){
                    if(visitedBuses.contains(bus)){
                        continue;
                    }
                    visitedBuses.add(bus);

                    for(int nextStop : routes[bus]){
                        if(nextStop == target){
                            return buses;
                        }
                        if(!visitedStops.contains(nextStop)){
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

//TC: O(n * k)
//SC: O(n * k). where n is number of busses and k is average stops number