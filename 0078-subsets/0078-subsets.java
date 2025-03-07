class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();//result stores list of all subsets
        List<Integer> subset = new ArrayList<>();//stores current subset
        dfs(nums, 0, subset, result);//recursively process elements starting from index '0'
        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result){
        //Base Case: if all elements are processed, add it to result
        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        //Inculde current element and recurr with next index
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, result);
        //Exculde current element and recurr with next index
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, result);
    }
}

//Time Complexity: O(n * 2^n)
//Space Complexity: O(n * 2^n) due to result list