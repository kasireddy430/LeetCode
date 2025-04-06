class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip : trips){
            int passengersCount = trip[0];
            int start = trip[1];
            int end = trip[2];

            diff[start] += passengersCount;
            diff[end] -= passengersCount;
        }

        int sum = 0;

        for(int i : diff){
            sum += i;

            if(sum > capacity) return false;
        }
        return true;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)