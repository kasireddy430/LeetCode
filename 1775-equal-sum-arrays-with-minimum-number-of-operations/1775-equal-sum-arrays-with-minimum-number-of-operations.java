class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > 6 * nums2.length || nums2.length > 6 * nums1.length) {
        return -1;
        }
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int diff = Math.abs(sum1 - sum2);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        if (sum1 > sum2) {
        for (int num : nums1) {
            pq.add(num - 1);
        }
        for (int num : nums2) {
            pq.add(6 - num);
        }
        } else {
        for (int num : nums1) {
            pq.add(6 - num);
        }
        for (int num : nums2) {
            pq.add(num - 1);
        }
        }
        int minOps = 0;
        while (!pq.isEmpty() && diff > 0) {
        diff -= pq.poll();
        minOps++;
        }
        return diff > 0 ? -1 : minOps;
    }
}