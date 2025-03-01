class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort the invervals based on their start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;//For tracking no.of intervals removed
        int prevEnd = intervals[0][1];//store the end value of previous interval

        //Iterate over each interval
        for(int i = 1; i < intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            //Check if previous interval doesn't overlap with current interval
            if(prevEnd <= start){
                //If so update previous interval end to current interval's end value
                prevEnd = end;
            } else{//If the intervals are overlapping, increment removal count and
                //update previous interval's end value
                res++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        //return mimimum no.of intervals that need to be removed
        return res;
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(1) or O(n) depending on the sorting algorithm