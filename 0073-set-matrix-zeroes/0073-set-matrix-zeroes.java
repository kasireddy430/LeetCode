class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){  
                if(matrix[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }

            for(int i = 0; i < matrix[0].length; i++){
                matrix[row][i] = 0;
            }
        }
    }
}


//Time Complexity: O(m * n)
//Space Complexity: O(1)