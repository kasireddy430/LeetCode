class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;//stores minimum distance to point (x, y)
        int index = -1;//stores index value

        //Iterate through input 2D array
        for(int i = 0; i < points.length; i++){
            //Check if current point is valid
            if(points[i][0] == x || points[i][1] == y){
                //Calculate Manhattan distance for current point
                int dis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);

                //If distance is smaller
                if(dis < min){
                    min = dis;
                    index = i;
                }
            }

        }
        return index;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
