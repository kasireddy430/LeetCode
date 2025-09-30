class Solution {
    /**
    Whenever A[i] > A[i - 1]
    we need at lease A[i] - A[i - 1] operations to make this difference.
    
    We accumulate the total number of the operations,
    this result is a lower bound and it's feasible.
    */

    // This can also be give as initial arra to be of all zeroes
    // https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
    /**
        Look at it like this. say uptill i-1 the total operations that have happened are res
        which has changed the ith position to it's current position
        so how many chnage will be required are diff - pre
        The operation is cumulative: when you increment A[i], you also increment all A[j] 
        where $j \< i$. This means the state of A[i] is a result of all operations 
        performed at or before index i.
 
     */
    public long minimumOperations(int[] A, int[] target) {
        long res = 0;
        long pre = 0;
        for (int i = 0; i < A.length; i++) {
            res = res + Math.max(target[i] - A[i] - pre, 0);
            pre = target[i] - A[i];
        }
        return res + Math.max(-pre, 0);
    }
}