class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int index = 0;

        for(int i = 1; i <= n/2; i++){
            res[index++] = i;
            res[index++] = -i;
        }

        return res;
    }
}

//TC: O(n)
//SC: O(n)