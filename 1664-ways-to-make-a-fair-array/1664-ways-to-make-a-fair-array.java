class Solution {
    public int waysToMakeFair(int[] A) {
        int n = A.length;
        if (n < 2)
            return n;
        int prefix = 0, suffix = A[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix = A[i] - suffix;
        int ans = 0;
        for (int num : A) {
            suffix = num - suffix;
            if (prefix == suffix)
                ans++;
            prefix = num - prefix;
        }
        return ans;
    }
}