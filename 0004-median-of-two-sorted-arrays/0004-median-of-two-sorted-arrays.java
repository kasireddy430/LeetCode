class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        int l = 0, r = A.length;

        while(l <= r){
            int i = (l + r)/2;
            int j = half - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int ARight = (i == A.length) ? Integer.MAX_VALUE : A[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int BRight = (j == B.length) ? Integer.MAX_VALUE : B[j];

            if(Aleft <= BRight && Bleft <= ARight){
                if(total % 2 != 0){
                    return Math.min(ARight, BRight);
                }
                return (Math.max(Aleft, Bleft) + Math.min(ARight, BRight))/2.0;
            } else if(Aleft > BRight){
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}

//TC: O(log (min(m,n)))
//SC: O(1)