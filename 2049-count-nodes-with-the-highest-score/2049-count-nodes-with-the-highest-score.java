class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;

        int[] inDegree = new int[n];

        for(int i = 1; i < n ; i++){
            inDegree[parents[i]]++;
        }

        int[] treeLength = new int[n], remain = new int[n];
        long[] score = new long[n];

        Arrays.fill(treeLength, 1);
        Arrays.fill(remain, n - 1);
        Arrays.fill(score, 1);
        int[] q = new int[n];
        
        int head = 0, tail = 0;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q[head++] = i;
                score[i] = n - 1;
            }
        }

        while(head > tail){
            int node = q[tail++];
            int pa = parents[node];

            if(pa == -1) continue;

            remain[pa] -= treeLength[node];
            treeLength[pa] += treeLength[node];
            score[pa] *= treeLength[node];

            if(--inDegree[pa] == 0){
                q[head++] = pa;
                if (pa != 0) score[pa] *= remain[pa];
            }  
        }


        int ans = 0;
        long max = 0;
        for (long s : score) {
            if (s == max) {
                ans++;
            } else if (max < s) {
                ans = 1;
                max = s;
            }
        }
        return ans;
    }
}