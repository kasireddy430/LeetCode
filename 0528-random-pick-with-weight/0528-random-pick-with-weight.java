class Solution {
    int[] arr;
    int sum = 0;
    Random random = new Random();
    public Solution(int[] w) {
        arr = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(sum) + 1;
        int l = 0, r = arr.length - 1;
        int candidate = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                candidate = m;
                r = m - 1;
            }
        }
        return candidate;
    }
    //       
    // w = [30, 20, 50]
    //arr= [30, 50, 100]
    //       m
    // target = 40
    // candidate = 1
    // l = 0, r = 2
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */