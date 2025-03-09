class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        //Stores job array with {start, end, profit} 
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        //sort jobs array based on end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        //TreeMap stores (endTime -> profit until endtime)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        //process jobs
        for(int[] job : jobs ){
            int start = job[0], end = job[1], currentProfit = job[2];

            //Calculate previous job profit(before start) using floorEntry(start)
            int previousProfit = map.floorEntry(start).getValue();

            int netProfit = previousProfit + currentProfit;

            //update treeMap if current net profit is greater 
            if(netProfit > map.lastEntry().getValue()){
                map.put(end, netProfit);
            }
        }

        //last entry in treemap holds maximum profit
        return map.lastEntry().getValue();
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(n)