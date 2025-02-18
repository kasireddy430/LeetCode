public class Solution {
    public void rotate(int[][] matrix) {
        //Initilize pointers tracking the boundaries of input matrix
        int left = 0, right = matrix.length - 1;

        //Base Case: Check if input array is empty
        if(matrix.length == 0){
            return;
        }

        //Iterate until both pointers meet
        while(left < right){
            //Loop through elements in current layer
            for(int i = 0; i < right - left; i++){
                int top = left, bottom = right;

                //Step 1 : temporarily store top-left element 
                int tmp = matrix[top][left + i];

                //Step 2 : Move bottom-left element to top-left 
                matrix[top][left + i] = matrix[bottom - i][left];

                //Step 3 : Move bottom-right element to bottom-left 
                matrix[bottom - i][left] = matrix[bottom][right - i];

                //Step 4 : Move top-right Element to bottom-right
                matrix[bottom][right - i] = matrix[top + i][right];

                //Step 5 : Update top-right with temporary element(which was top 
                //left element stored in step 1).
                matrix[top + i][right] = tmp;
            }

            //Move the pointers to process next layer
            left++;
            right--;
        }
    }
}


//Time Complexity: O(n ^ 2)
//Space Complexity: O(1)