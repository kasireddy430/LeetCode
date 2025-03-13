public class Solution {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        List<Integer> key = new ArrayList<>();
        int id = 2;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int size = dfs(grid, i, j, id);
                    key.add(size);
                    id++;
                }
            }
        }

        if(key.isEmpty()) return 1;

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int sum = 1;
                    Set<Integer> seen = new HashSet<>();

                    for(int[] dir : directions){
                        int r = i + dir[0];
                        int c = j + dir[1];

                        if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] >= 2){
                            int currentIsland = grid[r][c];
                            if(!seen.contains(currentIsland)){
                                sum += key.get(currentIsland - 2);
                                seen.add(currentIsland);
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        return max == 0 ? n * n : max;//if all elements are 1 
    }

    private int dfs(int[][] grid, int i, int j, int id){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = id;
        int count = 1;
        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];
            count += dfs(grid, row, col, id);
        }

        return count;
    }
}

//Time Complexity: O(n^2)
//Space Complexity: O(n^2)