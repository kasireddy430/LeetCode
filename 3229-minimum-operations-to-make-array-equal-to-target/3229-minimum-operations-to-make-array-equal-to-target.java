class Solution {

    public long minimumOperations(int[] A, int[] target) {
        long operations = 0;
        long prevDiff = 0;

        for(int i = 0; i < A.length; i++){
            long diff = target[i] - A[i];
            operations += Math.max(diff - prevDiff, 0);
            prevDiff = diff;
        }

        operations += Math.max(-prevDiff, 0);
        return operations;
    }
}

//TC: O(n)
//SC: O(1)