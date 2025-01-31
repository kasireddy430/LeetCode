class Solution {
    public void solve(char[][] board) {
        //Create a queue to store co-ordinates
        Queue<int[]> q = new LinkedList<>();

        //Calculate row and column length of 2-D array
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if the cell is border cell and holds 'O'
                if((r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) && board[r][c] == 'O'){
                    //If so update the cell to 'T'(marking the cell to be tempory
                    //such that it can be reverted back to 'O' at the end)
                    board[r][c] = 'T';
                    //Enqueue the coordinates
                    q.offer(new int[]{r, c});
                }
            }
        }

        //Define directions for bfs
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        //Iterate until until queue is empty
        while(!q.isEmpty()){
            //Dequeue the coordinates
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir:directions){
                int r = row + dir[0];
                int c = col + dir[1];

                //Check if the adjacent cell is valid and holds 'O' character
                if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O'){
                    q.offer(new int[]{r, c});
                    board[r][c] = 'T';//Mark it temporary
                }
            }
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if the  cell holds 'O'character
                if(board[r][c] == 'O'){
                    //If so update with 'X' character
                    board[r][c] = 'X';
                }//Flip temporary character back to 'O'
                else if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)