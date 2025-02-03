class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Calculate column and row length of 2-D array
        int ROW = matrix.length;
        int COL = matrix[0].length;
        //Initialize pointers at the start and end of the row in 2-d array
        int top = 0, bottom = ROW - 1;

        while(top <= bottom){
            //calculate the middle row index
            int mid = top + (bottom - top)/2;

            //Check if target element is greater than last element in mid row
            if(matrix[mid][COL - 1] < target){
                //If so move the top pointer since target could be found in any of the rows after mid
                top = mid + 1;
            } else if(matrix[mid][0] > target){
                //if target is less than first element in mid row, move the bottom pointer 
                bottom = mid - 1;
            } else {
                break;
            }
        }

        //return false if it's invalid row
        if(!(top <= bottom)){
            return false;
        }

        //Calculate potential row where element could be found
        int row = top + (bottom - top)/2;
        int left = 0, right = COL - 1;

        while(left <= right){
            int mid = left + (right - left)/2; //middle index
            if(matrix[row][mid] > target){
                //if target is less than middle element move right pointer
                right = mid - 1;
            } else if(matrix[row][mid] < target){
                //if target is greater then middle element move the left pointer
                left = mid + 1;
            } else {
                //return true when target is found
                return true;
            }
        }

        //return false when the target element isn't found
        return false;
    }
}

//Time Complexity: O(log m + log n)
//Space Complexity: O(1)