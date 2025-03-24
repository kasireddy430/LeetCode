class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, int[]> dp = new HashMap<>();
        int[] max = new int[k+2];

        for(int num : nums){
            int[] len = dp.get(num);

            if(len == null){
                len = new int[k+1];
                dp.put(num, len);
            }

            for(int j = k; j>= 0;j--){
                len[j] = Math.max(len[j], max[j]) + 1;
                max[j + 1] = Math.max(max[j + 1], len[j]);
            }
        }

        return max[k + 1];
    }
}

//Time Complexity: O(n * k)
//Space Complexity: O(n * k)