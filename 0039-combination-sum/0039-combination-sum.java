class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();//for storing all possible combinations
        List<Integer> cur = new ArrayList<>();//for tracking the current combination
        int total = 0; //for tracking current path sum

        //Sort arrays for optimization and have an early stopping
        Arrays.sort(candidates);

        //Recursively perform dfs starting from index 0
        dfs(0, candidates, target, res, cur, total);

        //return final list
        return res;
    }

    private void dfs(int i, int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int total){
        //Base case: if current sum equals target, then a valid combination is found
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        //Iterate from current element and look for valid combinations
        for(int j = i; j < candidates.length; j++){
            //If adding current element exceeds target value, then stop eleploring other combinations and do backtrack
            if(total + candidates[j] > target){
                return; //backtrack
            }

            //Add element at position i to cur list
            cur.add(candidates[j]);
            dfs(j, candidates, target, res, cur, total + candidates[j]);//recur with updated total including current element
            cur.remove(cur.size() - 1);//remove last added element for check other combinations
        }
    }
}

//Time Complexity: O(2^t/m)
//Space Complexity: O(t/m)
//where t is target value and m is smallest element in input array