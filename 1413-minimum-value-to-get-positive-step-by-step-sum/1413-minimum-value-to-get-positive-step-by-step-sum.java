class Solution {
    public int minStartValue(int[] nums) {
        
        int preFixSum = 0, minValue = Integer.MAX_VALUE;

        for(int num : nums){
            preFixSum += num;
            minValue = Math.min(minValue, preFixSum);
        }

        return minValue < 1 ? Math.abs(minValue) + 1 : 1;
    }
}

//TC: O(n)
//SC: O(1)