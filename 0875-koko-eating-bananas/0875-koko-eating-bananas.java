class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initiliza a variable to store maximum numbers of bananas in a pile
        int max = 0;

        //Iterate through piles array
        for(int i:piles){
            //Update max with pile with maximum size
            max = Math.max(max, i);
        }

        //Perform binary search with in range (1, max) to find minimum time taken to bananas in the piles 
        return bsa(piles, h, 1, max);
    }   

    private int bsa(int[] piles, int h, int left, int right){
        //Iterate until left > right
        while(left <= right){
            //Calculate middle index with in the range
            int mid = left + (right - left)/2;
            // Check if time taken to eat pile of bananas at speed of mid is less than h
            if(computeTime(piles, mid) <= h){
                //If so try reducing the time and perform binary search to find if smaller time is possible
                right = mid - 1;
            } else{
                // If not do bsa in other half by increasing the left pointer value
                left = mid + 1;
            }
        }
        return left;
    }

    private long computeTime(int[] piles, int k){
        // Variable to hold the total time taken to eat bananas in all piles
        long result = 0;
        // Iterate through each pile and calculate the time taken to eat all the piles with speed k
        for(int i:piles){
            //For each pile, the time is ceiling of pile/k
            result += (i + (k - 1))/k;
        }

        return result;
    }
}

// Time Complexity:O(n logm)
// Space Complexity:O(1)

// n represents the number of piles and m represents the maximum pile size
