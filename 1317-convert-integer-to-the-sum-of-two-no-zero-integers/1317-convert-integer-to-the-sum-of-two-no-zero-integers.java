class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++){
            int j = n - i;

            if(isNonZero(i) && isNonZero(j)){
                return new int[]{i, j};
            }
        }
        return new int[0];
    }

    private boolean isNonZero(int num){
        while(num != 0){
            if(num % 10 == 0) return false;
            num /= 10;
        }

        return true;
    }
}

//TC: O(n log n)
//SC: O(1)
