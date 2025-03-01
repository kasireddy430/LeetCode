class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //Base case: check if there are any meeting's
        if(intervals.length == 0){
            return true;
        }

        //sort intervals based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = intervals[0][1];//for tracking previous interval's ending time

        //Iterate through each interval
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];//start time for current interval
            int end = intervals[i][1];//end time for current interval

            //Check if current interval doesn't overlap with previous interval
            if(prevEnd <= start){
                prevEnd = end;
            } else {//If it overlap's, then a person cannot attend all meetings(return false)
                return false;
            }
        }

        //If none of the interval's overlap, them a person can attend all meetings(return true)
        return true;
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(1) or O(n) depending on the sorting algorithm