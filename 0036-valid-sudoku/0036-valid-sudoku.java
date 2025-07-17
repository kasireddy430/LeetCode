class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Create hashmap's to store characters from rows, columns and 3*3 squares
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        //Iterate over each cell in 9 * 9 matrix
        for(int i = 0; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char cell = board[i][j];

                //Check if cell is vali or not
                if(cell == '.'){
                    continue;
                }

                //calculate the index in 3 * 3 sqaures
                int index = (i/3) * 3 + (j/3);

                //check for duplicates in each of the rows, columns and sqaures
                if(rows.getOrDefault(i, new HashSet<>()).contains(cell) ||
                cols.getOrDefault(j, new HashSet<>()).contains(cell) ||
                squares.getOrDefault(index, new HashSet<>()).contains(cell)){
                    return false;
                }


                //store the each of the cell's values to rows, columns and squares
                rows.computeIfAbsent(i, k -> new HashSet<>()).add(cell);
                cols.computeIfAbsent(j, k -> new HashSet<>()).add(cell);
                squares.computeIfAbsent(index, k -> new HashSet<>()).add(cell);
            }
        }

        //If no duplicate is found return true indicating valid sudoku
        return true;
    }
}

//Time Complexity: O(1)
//Space COmplexity: O(1).fixed space for the hashmaps