class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        int diff = sum2 - sum1;
        if (diff == 0) return 0;
        int[] count = new int[6];
        for (int num : nums1) {
            count[6 - num]++; // increase smaller array
        }
        for (int num : nums2) {
            count[num - 1]++; // decrease
        }
        int ops = 0;
        for (int g = 5; g >= 1; g--) {
            while (count[g] > 0) {
                diff -= g;
                count[g]--;
                ops++;
                if (diff <= 0) return ops;
            }
        }
        return diff > 0 ? -1 : ops;
    }
}