class Solution {
    public int findShortestSubArray(int[] nums) {
        // Step1. Count numbers
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        // Step2. Find the degree of the whole array, which is used in sliding windwo algorithm to determine window status
        int degree = Collections.max(count.values());
        
        // Step3. Run sliding window. 
        // use a slow pointer to indicate the end of the window, and a scanning pointer 'fast' indicating the front of the window
        int slow = 0;
        int minLength = nums.length;
        Map<Integer, Integer> windowCount = new HashMap<>(); // window counter
        int windowDegree = 0;  // the degree in the window
        
        for(int fast = 0; fast < nums.length; fast++) {
            windowCount.put(nums[fast], windowCount.getOrDefault(nums[fast],0) + 1);
            windowDegree = Math.max(windowDegree, windowCount.get(nums[fast]));
            // when the window degree equals to the global degree, we need to minimize the window size, to find the min length
            while(windowDegree == degree) {
                // update our result
                minLength = Math.min(minLength, fast - slow + 1);
                
                // pop out the number at 'slow' pointer, and increment slow
                windowCount.put(nums[slow], windowCount.get(nums[slow]) - 1);
                slow++;
                
                // only when the number popped up equals to the newly added number, we can safely reduce the windowDegree
                // thus break the loop
                if(nums[slow - 1] == nums[fast]) {
                    windowDegree--;
                }
            }
        }
        return minLength;
    }
}