class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++){
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }

        for(int i = 0; i < n - 1; i++){

            if(arr[i + 1] - arr[i] == min){
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            
        }
        return res;
    }
}

//TC: O(n log n)
//SC: O(n)