class Solution {
public int[] colorTheArray(int n, int[][] queries) {
        int count = 0;
        int[] nums = new int[n];
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], val = queries[i][1];
            
            if(idx > 0) {
                if(nums[idx-1] == 0);
                else if(nums[idx] == nums[idx-1]) {
                    if(nums[idx] != val && count > 0) count--;
                }
                else {
                    if(val == nums[idx-1]) count++;
                }
            }
			
            if(idx+1 < n) {
                if(nums[idx+1] == 0);
                else if(nums[idx] == nums[idx+1]) {
                    if(nums[idx] != val && count > 0) count--;
                }
                else {
                    if(val == nums[idx+1]) count++;
                }
            }
            
            nums[idx] = val;
            result[i] = count;
        }
        
        return result;
    }
}