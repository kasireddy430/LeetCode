class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int total = 0;
        int subTotal = 0;

        for(int[] task : tasks){
            int actual = task[0];
            int req = task[1];

            //minmumInitialEnergy - energyUsedUntilNow >= requiredEnergy
            total = Math.max(total, req + subTotal);
            subTotal += actual;
        }

        return total;
    }
}

//TC: O(n log n)
//SC: O(1)