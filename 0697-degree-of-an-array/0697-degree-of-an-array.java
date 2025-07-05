class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxValue = 50000;
        int[] freq = new int[maxValue];
        int[] first = new int[maxValue];
        int[] last = new int[maxValue];
        for (int i = 0; i < maxValue; i++) {
            freq[i] = -1;
        }
        int degree = 0;
        int minlength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (freq[num] == -1) {
                first[num] = i;
            }
            last[num] = i;
            freq[num]++;
            degree = Math.max(degree, freq[num]);
        }
        for (int i = 0; i < maxValue; i++) {
            if (freq[i] == degree) {
                minlength = Math.min(minlength, last[i] - first[i] + 1);
            }
        }
        return minlength;
        
    }
}