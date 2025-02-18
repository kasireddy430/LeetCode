public class DetectSquares {
    //map to store frequencies of points 
    private Map<List<Integer>, Integer> count;
    //list to store all the points
    private List<List<Integer>> pts;

    //Constructor initializes both map and list
    public DetectSquares() {
        count = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        //Convert array to list
        List<Integer> p = Arrays.asList(point[0], point[1]);
        //update frequency of the input point
        count.put(p, count.getOrDefault(p, 0) + 1);
        //Add the point to list of points
        pts.add(p);
    }

    public int count(int[] point) {
        int res = 0;
        //Retrieve the x and y coordinates of the point
        int px = point[0], py = point[1];

        //Iterate over list of points already present
        for(List<Integer> pt : pts){
            int x = pt.get(0), y = pt.get(1);

            //A valid square does have a condition for diagnol, where distance between x and their 
            //y coordinates should be same and their x-y cordinates should be different
            if((Math.abs(px - x) != Math.abs(py - y)) || x == px || y == py){
                continue;
            }

            //Other coordinates(x, py) and (px, y) should exist for a valid square
            res += count.getOrDefault(Arrays.asList(x, py), 0) *
                    count.getOrDefault(Arrays.asList(px, y), 0);
        }

        //return number of squares for the given point
        return res;
    }
}

//Time Complexity: O(n) contributed by count.
//Space Complexity: O(n) for both map and the list


/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */