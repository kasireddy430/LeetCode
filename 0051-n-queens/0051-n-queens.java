public class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDia = new HashSet<>();
    Set<Integer> negDia = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
        }

        for(int c = 0; c < n; c++){
            if(cols.contains(c) || posDia.contains(r + c) || negDia.contains(r - c)){
                continue;
            }

            cols.add(c);
            posDia.add(r + c);
            negDia.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board);

            cols.remove(c);
            posDia.remove(r + c);
            negDia.remove(r - c);
            board[r][c] = '.';
        }
    }
}

//TC: O(n! + S*n^2)
//SC: O(n^2)