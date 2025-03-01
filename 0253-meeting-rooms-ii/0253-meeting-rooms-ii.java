class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Base Case: Check if there are any meetings
        if(intervals.length == 0){
            return 0;
        }

        //Sort intervals based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //For tracking the meeting end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //Iterate through intervals
        for(int[] interval : intervals){
            //Check if earliest meeting is ended before current meeting
            if(!minHeap.isEmpty() && minHeap.peek() <= interval[0]){
                //If so remove earliest meeting end time from minHeap
                minHeap.poll();
            }
            //Add current meeting's end time to heap
            minHeap.offer(interval[1]);
        }

        //minHeap's size tells us the number of concurrent meetings
        return minHeap.size();
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(n)