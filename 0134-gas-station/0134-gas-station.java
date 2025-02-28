class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Step 1: Quick Feasibility Check
        //if total gas available is less than the total cost, then it is impossible to complete circular route
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }

        int total = 0; //tracking net fuel at each gas station
        int res = 0; //Stores the starting gas station index, where we can visit all gas stations
        //Step 2:Iterate through each gas station
        for(int i = 0; i < gas.length; i++){
            total += (gas[i] - cost[i]); //calculate next fuel at index i

            //If net fuel is negative, reset the net fuel and update starting point to next step
            if(total < 0){
                total = 0;
                res = i + 1;
            } 
        }
        //return the starting gas station's index
        return res; 
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)