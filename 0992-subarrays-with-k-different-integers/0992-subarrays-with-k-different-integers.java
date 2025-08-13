class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarraysWithAtMostKDistinct(nums, k) 
             - countSubarraysWithAtMostKDistinct(nums, k - 1);
    }

    private int countSubarraysWithAtMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int[] frequency = new int[n + 2]; // works only if nums[i] <= n
        int distinctCount = 0;
        int totalSubarrays = 0;

        while (right < n) {
            if (frequency[nums[right]] == 0) {
                distinctCount++;
            }
            frequency[nums[right]]++;

            while (distinctCount > k) {
                frequency[nums[left]]--;
                if (frequency[nums[left]] == 0) {
                    distinctCount--;
                }
                left++;
            }

            // All subarrays ending at 'right' with start >= left are valid
            totalSubarrays += (right - left + 1);
            right++;
        }

        return totalSubarrays;
    }
}
