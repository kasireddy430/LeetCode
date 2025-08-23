//Hierholzer’s algorithm is a classic graph algorithm used to find an Eulerian circuit (or path) in a graph.
//An Eulerian path is a path that visits every edge in the graph exactly once.
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String start,  Map<String, PriorityQueue<String>> map, LinkedList<String> res){
        PriorityQueue<String> q = map.get(start);

        while(q != null && !q.isEmpty()){
            dfs(q.poll(), map, res);
        }

        res.addFirst(start);
    }
}