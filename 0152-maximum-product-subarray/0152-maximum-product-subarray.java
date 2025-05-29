class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], globalProduct = nums[0];

        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];

            int tmpMax = Math.max(cur, Math.max(cur * maxProduct, cur * minProduct));
            minProduct = Math.min(cur, Math.min(cur * maxProduct, cur * minProduct));
            maxProduct = tmpMax;

            globalProduct = Math.max(globalProduct, maxProduct);
        }

        return globalProduct;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)