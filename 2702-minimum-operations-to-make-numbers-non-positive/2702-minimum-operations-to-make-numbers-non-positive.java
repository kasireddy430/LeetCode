class Solution {
    public int minOperations(int[] nums, int x, int y) {
        int right = nums[0];
        for (int v : nums) {
            right = Math.max(v, right);
        }
        int left = 1;
        right = right / y;
        x -= y;
        while (left <= right) {
            int mid = (left + right) >> 1, s = mid;
            for (int v : nums) {
                int t = (v + y - 1) / y;
                if (mid >= t) {
                    continue;
                }
                s -= (v - mid * y + x - 1) / x;
                if (s < 0) {
                    break;
                } 
            }
            if (s >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
        
    }
}