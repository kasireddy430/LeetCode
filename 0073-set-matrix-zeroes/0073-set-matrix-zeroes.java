class Solution {
    public void setZeroes(int[][] matrix) {
        //Calculate the row and column length of input matrix
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        //Create a boolean variable for tackling the first row
        boolean firstRow = false;

        //Mark first row and first column of the input matrix
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //Check if current cell is 0
                if(matrix[r][c] == 0){
                    //If so, Mark first row and the first column with 0 respective to current cell
                    matrix[0][c] = 0;
                    //If current cell is not part of first row
                    if(r > 0){
                        //Mark first row respective to current cell
                        matrix[r][0] = 0;
                    } else{
                        //If first row needs to be zeroed out update boolean value
                        firstRow = true;
                    }
                }
            }
        }

        //Mark all the rows and columns except first row 
        //and first column with zero
        for(int r = 1; r < ROWS; r++){
            for(int c = 1; c < COLS; c++){
                //If any of the first row or column is marked then make current cell 0
                if(matrix[0][c] == 0 || matrix[r][0] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        //Mark first column zero if necessary
        if(matrix[0][0] == 0){
            for(int r = 1; r < ROWS; r++){
                //Mark entire colum zero
                matrix[r][0] = 0;
            }
        }

        //Mark first row zero if required
        if(firstRow){
            for(int c = 0; c < COLS; c++){
                //Mark first row 0
                matrix[0][c] = 0;
            }
        }
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(1)