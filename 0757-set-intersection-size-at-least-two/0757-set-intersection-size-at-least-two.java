class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int point1 = -1, point2 = -1;
        int count = 0;

        for(int[] interval : intervals){
            if(point1 == -1){
                count += 2;
                point1 = interval[1] - 1;
                point2 = interval[1];
            } else if(interval[0] <= point1){
                continue;
            } else if(interval[0] <= point2){
                point1 = point2;
                point2 = interval[1];
                count++;
            } else{
                count += 2;
                point1 = interval[1] - 1;
                point2 = interval[1];                
            }
        }
        return count;
    }
}

//Time Complexity: O(n log n)
//Space Complexity: O(n). where n is no.of intervals