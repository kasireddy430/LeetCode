class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort interval based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //Create a list to store the result of merged sorted list
        LinkedList<int[]> res = new LinkedList<>(); //using linkedList makes easier to extract last element from list

        //Iterate over each interval
        for(int[] interval: intervals){
            //Check if the result list is empty or check if previous
            //interval does not overlap with current interval
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                //If so both interval's aren't overlapping, add current interval to result list
                res.add(interval);
            } else {//If interval's meet, update the ending interval value
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        //Convert result list to 2D array and return it
        return res.toArray(new int[res.size()][]);
    }
}

//Time Complexity: O(n log n) contributed by sorting the input array
//Space Complexity: O(n)