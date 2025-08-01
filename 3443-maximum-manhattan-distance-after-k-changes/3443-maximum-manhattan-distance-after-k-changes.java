class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int ans = 0;

        for(char c : s.toCharArray()){
            switch(c){
                case 'N' : north++; break;
                case 'S' : south++; break;
                case 'E' : east++; break;
                case 'W' : west++; break;
            }

            int verticalMod = Math.min(Math.min(north, south), k);
            int horizontalMod = Math.min(Math.min(east, west), k - verticalMod);

            int maxDist = Math.abs(north - south) + 2 * verticalMod + 
                            Math.abs(east - west) + 2 * horizontalMod;
            ans = Math.max(ans, maxDist);
        }
        return ans;
    }
}

//TC: O(n)
//SC: O(1)