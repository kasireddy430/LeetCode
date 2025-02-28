class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //Initialize boolean variables to check if we can get target elements from triplets array
        boolean x = false, y = false, z = false;

        //Iterate over each input 2-D array
        for(int[] triplet : triplets){
            //Update flags if target elements can be achieved in their respective positions
            x |= (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]);
            y |= (triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2]);
            z |= (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2]);

            //Return true if all target element are found
            if(x && y && z){
                return true;
            }
        }

        //return false if target isn't found
        return false;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)