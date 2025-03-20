class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = -1;
        int max = 1;
        int length = seats.length;

        for(int r = 0;r < length; r++){
            if(seats[r] == 1){
                if(l == -1) max = r;

                max = Math.max(max, (r - l)/2);
                l = r;
            }
        }
        return Math.max(max, length - (l + 1));
    }
}


//Time Complexity: O(n)
//Space Complexity: O(1)