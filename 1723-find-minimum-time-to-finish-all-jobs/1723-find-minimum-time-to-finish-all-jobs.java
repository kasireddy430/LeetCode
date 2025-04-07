class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);

        int start = 0, end = 0;

        for(int job : jobs){
            start = Math.max(job, start);
            end += job;
        }

        while(start < end){
            int mid = start + (end - start)/2;

            if(contribute(jobs, jobs.length - 1, new int[k], mid)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private boolean contribute(int[] jobs, int index, int[] workload, int limit){
        if(index < 0) return true;

        int currentjob = jobs[index];

        for(int i = 0; i < workload.length; i++){
            if(workload[i] + currentjob <= limit){
                workload[i] += currentjob;

                if(contribute(jobs, index - 1, workload, limit)) return true;

                workload[i] -= currentjob;
            }

            if(workload[i] == 0) break;
        }
        return false;
    }
}

//Time Complexity: O(k^n * log(sum(jobs)))
//Space Complexity: O(k^n)