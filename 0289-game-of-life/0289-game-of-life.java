class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int neighborCount = findNeighbors(board, i , j);

                if(board[i][j] == 1){
                    if(neighborCount < 2 || neighborCount > 3){
                        board[i][j] = 2; //live -> dead
                    }
                } else {
                    if(neighborCount == 3){
                        board[i][j] = 3; //dead -> live
                    }
                }
            }
        }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 2){
                        board[i][j] = 0;
                    } else if(board[i][j] == 3){
                        board[i][j] = 1;
                    }
                }
            }
        
    }

    private int findNeighbors(int[][] board, int i, int j){
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, 
                            {-1, 1}, {1, 1}};

        int count = 0;

        for(int[] dir : directions){
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length){
                if(board[r][c] == 1 || board[r][c] == 2){
                    count++;
                }
            }
        }
        return count;
    }
}

//TC: O(mn)
//SC: O(1)