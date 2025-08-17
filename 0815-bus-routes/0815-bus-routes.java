class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        int busCount = routes.length;
        for(int bus = 0; bus < busCount; bus++){
            for(int stop : routes[bus]){
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(bus);
            }
        }

        if(!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)){
            return -1;
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        q.add(source);
        visitedStops.add(source);
        int busses = 0;

        while(!q.isEmpty()){
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
                            return busses + 1;
                        }

                        if(!visitedStops.contains(nextStop)){
                            q.offer(nextStop);
                            visitedStops.add(nextStop);
                        }
                    }
                }
            }

            busses++;
        }

        return -1;
    }
}

//TC: O(n * k)
//SC: O(n * k). where n is number of busses and k is average stops number