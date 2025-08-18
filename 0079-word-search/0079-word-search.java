class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
        word.charAt(i) != board[r][c] || board[r][c] == '#'){
            return false;
        }

        char tmp = board[r][c];
        board[r][c] = '#';

        boolean res = dfs(board, word, r + 1, c, i + 1) ||
        dfs(board, word, r - 1, c, i + 1) ||
        dfs(board, word, r, c + 1, i + 1) ||
        dfs(board, word, r, c - 1, i + 1);

        board[r][c] = tmp;

        return res;
    }
}

//TC: O(n * 4 ^ L)
//SC: O(L). where n is number of cells and L is length of word