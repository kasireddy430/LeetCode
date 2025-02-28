class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Initialize a list to store list of merged intervals
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            //Check if current interval's comes before new Interval
            if(newInterval == null || interval[1] < newInterval[0]){
                //If so add current interval to the list
                res.add(interval);
            }//Check if current interval comes after new Interval
            else if(interval[0] > newInterval[1]){
                //If so add both the interval's to the list and mark newInterval merged
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {//If current and new interval overlap, update new interval as merged interval of both
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        //If newInterval does not overlap with any of the input intervals array
        //add it to the result list
        if(newInterval != null){
            res.add(newInterval);
        }

        //Convert the result list to 2-D array and return it
        return res.toArray(new int[res.size()][]);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)