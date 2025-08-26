class CountSquares {
    Map<List<Integer>, Integer> ptsCount;

    public CountSquares() {
        ptsCount = new HashMap<>();
    }

    public void add(int[] point) {
        List<Integer> pt = Arrays.asList(point[0], point[1]);
        ptsCount.put(pt, ptsCount.getOrDefault(pt, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int res = 0;

        // Iterate over unique points only
        for (List<Integer> pt : ptsCount.keySet()) {
            int x = pt.get(0), y = pt.get(1);

            // Check if this point can form a square with (px, py)
            if (x == px || y == py || Math.abs(x - px) != Math.abs(y - py)) {
                continue;
            }

            // Multiply counts for the other two corners
            int c1 = ptsCount.getOrDefault(Arrays.asList(px, y), 0);
            int c2 = ptsCount.getOrDefault(Arrays.asList(x, py), 0);

            res += ptsCount.get(pt) * c1 * c2;
        }

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