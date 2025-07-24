class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] time : times){
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int path = cur[0], u = cur[1];

            if(visited.contains(u)){
                continue;
            }

            visited.add(u);
            t = path;

            if(map.containsKey(u)){
                for(int[] edge : map.get(u)){
                    int v = edge[0];
                    int w = edge[1];

                    if(!visited.contains(v)){
                        q.offer(new int[]{path + w, v});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}

//TC: O(E log V)
//SC: O(V + E)