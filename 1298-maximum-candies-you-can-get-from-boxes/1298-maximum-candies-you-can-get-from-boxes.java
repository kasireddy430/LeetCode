class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int res=0, n=status.length;
        Queue<Integer> opened = new LinkedList<>();
        int closed[] = new int[n]; // box -> 1 if found but we have no keys yet, 0 - otherwise; 0 by default
        for(int b:initialBoxes)
            if(status[b]==1) opened.add(b);
            else             closed[b]=1;
        while(!opened.isEmpty()) {
            int b = opened.poll();
            res += candies[b];
            for(int k:keys[b]) { // take new keys and try to open closed boxes
                if(closed[k]==1) { closed[k]=0; opened.add(k); }
                status[k]=1;
            }
            for(int found:containedBoxes[b]) { // take new boxes and try to open them
                if(status[found]==1)  opened.add(found);
                else                  closed[found]=1;
            }
        }
        return res;
    }
};