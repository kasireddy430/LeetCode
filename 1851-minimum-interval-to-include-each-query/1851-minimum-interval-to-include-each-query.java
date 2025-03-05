class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int querySize = queries.length;

        //sort intervals in ascending order based on their start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //Create a 2-D array to store queries along side their indices
        int[][] queryWithIndex = new int[querySize][2];
        for(int i = 0; i < querySize; i++){
            queryWithIndex[i] = new int[]{queries[i], i};
        }

        //sort queries based on the query value
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);

        //Create min-Heap to store intervals based on the interval size in ascending order
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        
        int j = 0;

        //Create a result array to store query results
        int[] result = new int[querySize];

        //process queries
        for(int i = 0; i < queryWithIndex.length; i++){
            int queryVal = queryWithIndex[i][0];
            int queryIndex = queryWithIndex[i][1];

            //store intervals in minHeap if their start value is less than or equal to query value
            while( j < intervals.length && intervals[j][0] <= queryVal){
                minHeap.offer(intervals[j]);
                j++;
            }

            //remove the interval if it's end value is less than query value
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal){
                minHeap.remove();
            }

            //store -1 if heap is empty if not store the interval range in result array
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        } 

        return result;
    }
}

//Time Complexity: O(nlog n + qlog q)
//Space Complexity: O(n + q). n - no.of intervals. q - no.of queries