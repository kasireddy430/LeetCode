class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int pile : piles){
            max = Math.max(pile, max);
        }

        return bsa(piles, h, 1, max);
    }

    private int bsa(int[] piles, int h, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2;

            if(computeTime(piles, mid) <= h){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long computeTime(int[] piles, int k){
        long sum = 0;
        for(int pile : piles){
            sum += (pile + (k - 1))/k;
        }
        return sum;
    }
}

// Time Complexity:O(n logm)
// Space Complexity:O(1)

// n represents the number of piles and m represents the maximum pile size
