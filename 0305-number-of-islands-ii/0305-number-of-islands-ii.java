class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();

        if(m <= 0 || n <= 0){
            return res;
        }

        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;


        for(int[] position : positions){
            int row = position[0];
            int col = position[1];
            int index = row * n + col;

            if(roots[index] != -1){
                res.add(count);
                continue;
            }

            roots[index] = index;
            count++;

            for(int[] dir : directions){
                int r = row + dir[0];
                int c = col + dir[1];
                int nei = r * n + c;

                if(r < 0 || r >= m || c < 0 || c >= n || roots[nei] == -1){
                    continue;
                }

                int root1 = find(roots, index);
                int root2 = find(roots, nei);

                if(root1 != root2){
                    roots[root1] = root2;
                    count--;
                }
            }

            res.add(count);
        }

        return res;
    }


    private int find(int[] roots, int i){
        while(roots[i] != i){
            roots[i] = roots[roots[i]];
            i = roots[i];
        }

        return roots[i];
    }
}

//TC: O(k * @(m * n))
//SC: O(k + m * n)
