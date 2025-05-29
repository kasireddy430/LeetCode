class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], globalProduct = nums[0];

        for(int i = 1; i < nums.length; i++){
            int current = nums[i];

            int tempMax = Math.max(current, Math.max(maxProduct * current, minProduct * current));
            minProduct = Math.min(current, Math.min(maxProduct * current, minProduct * current));

            maxProduct = tempMax;
            globalProduct = Math.max(globalProduct, maxProduct);

        }

        return globalProduct;
    }
}

//Time Complexity: O(n)
//Space COmplexity: O(1)