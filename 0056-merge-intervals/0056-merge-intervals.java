class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort interval based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //Create a list to store the result of merged sorted list
        LinkedList<int[]> res = new LinkedList<>(); //using linkedList makes easier to extract last element from list

        for(int[] interval: intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

//Time Complexity: O(n log n) contributed by sorting the input array
//Space Complexity: O(n)