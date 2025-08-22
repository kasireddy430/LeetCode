/**
 * Simulate Diagonal Order Traversal
 *
 * r+c determines which diagonal you are on. For ex: [2,0],[1,1],[0,2] are all
 * on same diagonal with r+c =2. If you check the directions of diagonals, first
 * diagonal is up, second diagonal is down, third one is up and so on..
 * Therefore (r+c)%2 simply determines direction. Even is UP direction. Odd is
 * DOWN direction.
 *
 * Time Complexity: O(M*N)
 *
 * Space Complexity: O(M*N) considering result space.
 *
 * M = Number of rows. N = Number of columns.
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows*cols];
        int r = 0;
        int c = 0;

        for(int i = 0; i < result.length; i++){
            result[i] = matrix[r][c];
            if((r + c) % 2 == 0){//goes up
                if(c == cols-1){
                    r++;
                } else if(r == 0){
                    c++;
                } else{
                    r--;
                    c++;
                }
            } else {
                if(r == rows - 1){
                    c++;
                } else if (c == 0){
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}

//TC: O(m*n)
//SC: O(m*n)