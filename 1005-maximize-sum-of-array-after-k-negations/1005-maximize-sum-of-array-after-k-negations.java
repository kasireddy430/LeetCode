class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        if (A[0] >= 0 && K % 2 != 0) {
            A[0] = - A[0];
        } else if (A[0] < 0 ) { //&& K % 2 == 0) {
            int change = 0;
            while (K > 0  && change < A.length && A[change] < 0) {
                A[change] = - A[change++];
                K--;
            }
            if (K % 2 != 0) {
                int index = change < A.length && A[change] < A[change - 1] ? change : change - 1;
                A[index] = - A[index];
            }
        }
        for (int val : A) sum += val;
        return sum;
    }
}