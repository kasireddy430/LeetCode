class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();

        return original;
    }
    
    public int[] shuffle() {
        for(int i = 0; i < array.length; i++){
            swapAt(i, randRange(i, array.length));
        }

        return array;
    }

    private void swapAt(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int randRange(int min, int max){
        return rand.nextInt(max - min) + min;
    }
}

//TC:
//SC:

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */