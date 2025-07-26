class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int[] point : points){
            int dist = point[0] * point[0] + point[1] * point[1];
            q.offer(new int[]{dist, point[0], point[1]});

            if(q.size() > k){
                q.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] cur = q.poll();
            res[i] = new int[]{cur[1], cur[2]};
        }

        return res;
    }
}