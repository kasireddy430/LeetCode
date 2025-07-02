class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for(int i = 0; i < bombs.length;i++){
            max = Math.max(max, bfs(i, bombs));
        }

        return max;
    }

    private int bfs(int k, int[][] bombs){
        int count = 1;

        boolean[] visited = new boolean[bombs.length];
        visited[k] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);

        while(!q.isEmpty()){
            int i = q.poll();

            for(int j = 0; j < bombs.length;j++){
                if(!visited[j] && isInRadius(bombs[i], bombs[j])){
                    visited[j] = true;
                    count++;
                    q.offer(j);
                }
            }
        }
        return count;
    }

    private boolean isInRadius(int[] bomb1, int[] bomb2){
        long x = bomb1[0] - bomb2[0];
        long y = bomb1[1] - bomb2[1];

        long r = bomb1[2];

        return x * x + y * y <= r * r;
    }
}

//TC: O(n ^ 3)
//SC : O(n)

