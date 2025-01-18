class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            visitIsland(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    private void visitIsland(int[][] image, int sr, int sc, int color, int oldColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor){
            return;
        }

        image[sr][sc] = color;

        visitIsland(image, sr + 1, sc, color, oldColor);
        visitIsland(image, sr - 1, sc, color, oldColor);
        visitIsland(image, sr, sc + 1, color, oldColor);
        visitIsland(image, sr, sc - 1, color, oldColor);
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n). Contributed by recursion stack