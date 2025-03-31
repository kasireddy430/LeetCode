class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: If the array is empty, LIS is 0
        
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the length of the LIS ending at index i
        Arrays.fill(dp, 1);  // Initialize all elements as 1 since every number alone is an LIS
        
        int maxLIS = 1; // Variable to track the maximum LIS
        
        // Iterate through the array to build the dp array
        for (int i = 1; i < n; i++) { // Start from the second element
            for (int j = 0; j < i; j++) { // Compare with all previous elements
                if (nums[i] > nums[j]) { // If nums[i] extends the LIS ending at nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update dp[i] with the longest LIS so far
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]); // Update the maximum LIS found so far
        }
        
        return maxLIS; // Return the maximum LIS found in the array
    }
}
