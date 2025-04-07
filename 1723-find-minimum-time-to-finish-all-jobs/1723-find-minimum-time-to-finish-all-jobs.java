class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int start = 0, end = 0;
        Arrays.sort(jobs); // Sort jobs to assign larger ones first via reverse order
        for (int job : jobs) {
            start = Math.max(start, job);
            end += job;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canDistribute(jobs, new int[k], jobs.length - 1, mid)) {
                end = mid; // Try smaller max load
            } else {
                start = mid + 1; // Increase allowed max load
            }
        }

        return end;
    }

    private boolean canDistribute(int[] jobs, int[] workloads, int index, int limit) {
        if (index < 0) return true;

        for (int i = 0; i < workloads.length; i++) {
            if (workloads[i] + jobs[index] <= limit) {
                workloads[i] += jobs[index];
                if (canDistribute(jobs, workloads, index - 1, limit)) return true;
                workloads[i] -= jobs[index];
            }

            // Prune: if the worker has no job yet, skip trying other empty workers
            if (workloads[i] == 0) break;
        }

        return false;
    }
}
