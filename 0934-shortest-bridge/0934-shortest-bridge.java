class Solution {
  private int n;
  private int[][] moves = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
  private Queue<int[]> queue = new ArrayDeque<>();

  private void discoverIsland(int[][] grid, int x, int y) {
    grid[x][y] = 2;
    queue.add(new int[] {x, y});

    for (var move : moves) {
      var x2 = x + move[0];
      var y2 = y + move[1];

      if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n)
        if (grid[x2][y2] == 1)
          discoverIsland(grid, x2, y2);
    }
  }

  public int shortestBridge(int[][] grid) {
    n = grid.length;
    int x = 0, y = 0;
    var br = false;

    for (x=0; x<n && !br; x++) {
      for (y=0; y<n && !br; y++) {
        if (grid[x][y] == 1) {
          discoverIsland(grid, x, y);
          br = true;
        }
      }
    }
    for (var cnt = 0; ; cnt++) {
      for (var i = queue.size(); i > 0; i--) {
        var pos = queue.poll();

        for (var move : moves) {
          var x2 = pos[0] + move[0];
          var y2 = pos[1] + move[1];

          if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n) {
            if (grid[x2][y2] == 1)
              return cnt;
            else if (grid[x2][y2] == 0) {
              queue.add(new int[] {x2, y2});
              grid[x2][y2] = -1;
            }
          }
        }
      }
    }
  }
}