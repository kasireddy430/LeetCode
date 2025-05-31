class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset, result);
        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result){

        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(nums, i + 1, subset, result);
    }
}

//TC: O(n * 2 ^ n)
//SC: O(n * 2 ^ n)