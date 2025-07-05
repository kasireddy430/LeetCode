class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new int[]{i, i, 1});
            } else {
                int[] arr = map.get(num);
                arr[1] = i;
                arr[2]++;
            }
            degree = Math.max(degree, map.get(num)[2]);
        }
        int minLen = nums.length;
        for (int key : map.keySet()) {
            int[] arr = map.get(key);
            if (arr[2] == degree) {
                minLen = Math.min(minLen, arr[1] - arr[0] + 1);
            }
        }
        return minLen;
    }
}