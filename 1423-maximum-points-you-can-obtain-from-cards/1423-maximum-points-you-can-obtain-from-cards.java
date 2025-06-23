class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int requiredSubArrayLength = n - k;
        int totalScore = 0;
        int minSubArrayScore = 0;
        int subArrayScore = 0;
        int l = 0;

        for(int card : cardPoints){
            totalScore += card;
        }

        minSubArrayScore = totalScore;

        if(k == n){
            return totalScore;
        }

        for(int i = 0; i < n; i++){
            subArrayScore += cardPoints[i];
            int subArrayLength = i - l + 1;

            if(subArrayLength == requiredSubArrayLength){
                minSubArrayScore = Math.min(minSubArrayScore, subArrayScore);
                subArrayScore -= cardPoints[l++];
            }
        }

        return totalScore - minSubArrayScore;
    }
}

//TC: O(n)
//SC: O(1)