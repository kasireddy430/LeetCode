class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] res = new char[n][m];

        for(char[] row : res){
            Arrays.fill(row, '.');
        }

        for(int r = 0; r < m; r++){
            int i = n - 1;

            for(int c = n - 1; c >= 0; c--){
                if(box[r][c] == '#'){
                   res[i][m - r - 1] = '#';
                   i--; 
                } else if(box[r][c] == '*'){
                    res[c][m - r - 1] = '*';
                    i = c - 1;
                }
            }
        }

        return res;
    }
}

//TC: O(Rows * Cols)
//SC: O(Rows * Cols)