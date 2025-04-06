class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        // start will max from jobs
        int start = 0;
        // end is sum of all jobs
        int end = 0;
        Arrays.sort(jobs);
        for(int job: jobs) {
            start = Math.max(start, job);
            end += job;
        }
        int result = -1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(find(jobs, new int[k], 0, mid)) {
                result = mid; 
                end = mid;
            } else start = mid + 1;
        }
        return end;
    }

    private boolean find(int[] jobs, int[] sum, int index, int mid) {
        if(index == jobs.length) return true;
        for(int i = 0; i < sum.length; i++) {
            if(sum[i] + jobs[index] <= mid) {
                sum[i] += jobs[index];
                if(find(jobs, sum, index + 1, mid)) return true;
                sum[i] -= jobs[index];
            }
            if(sum[i] == 0) break;
        }
        return false;
    }
}