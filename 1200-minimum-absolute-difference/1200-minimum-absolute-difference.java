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
            List<Integer> list = new ArrayList<>();

            if(arr[i + 1] - arr[i] == min){
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            }
            
        }
        return res;
    }
}