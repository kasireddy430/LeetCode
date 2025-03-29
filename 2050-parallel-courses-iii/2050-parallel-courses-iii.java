class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] relation : relations){
            int prev = relation[0] - 1;
            int nxt = relation[1] - 1;

            graph.get(nxt).add(prev);
        }

        int[] memo = new int[n];
        int overallTime = 0;
        for(int i = 0; i < n; i++){
            overallTime = Math.max(overallTime, completeCourse(i, graph, time, memo));
        }

        return overallTime;
    }

    private int completeCourse(int cur, List<List<Integer>> graph, int[] time, int[] memo){
        if(memo[cur] != 0){
            return memo[cur];
        }

        int coursePreTime = 0;        
        for(int preReq : graph.get(cur)){
            coursePreTime = Math.max(coursePreTime, completeCourse(preReq, graph, time, memo));
        }

        memo[cur] = coursePreTime + time[cur];

        return memo[cur];
    }
}

//Time Complexity: O(V + E) for graph construction
//Space Complexity: O(V + E) for storing graph