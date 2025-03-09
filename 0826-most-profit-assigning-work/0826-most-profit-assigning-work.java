class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //Find maximum difficulty job
        int maxAbility = 0;
        for(int i = 0; i < difficulty.length; i++){
            maxAbility = Math.max(maxAbility, difficulty[i]);
        }

        //Create a look-up to store profites for each difficulty level's
        int[] maxDifficultyProfit = new int[maxAbility + 1];
        for(int i = 0; i < difficulty.length; i++){
            maxDifficultyProfit[difficulty[i]] = Math.max(maxDifficultyProfit[difficulty[i]], profit[i]);
        }

        //Compute max profit for each difficulty level
        for(int i = 1; i <= maxAbility; i++){
             maxDifficultyProfit[i] = Math.max(maxDifficultyProfit[i], maxDifficultyProfit[i - 1]);
        }

        //assign profitable job to each worker
        int result = 0;
        for(int ability : worker){
            if(ability > maxAbility){
                result += maxDifficultyProfit[maxAbility];
            } else{
                result += maxDifficultyProfit[ability];
            }
        }

        return result;//return max profit
    }
}


//Time Complexity: O(m * n * maxAbility). where m = difficulty.length and n = worker.length
//Space Complexity: O(maxAbility)