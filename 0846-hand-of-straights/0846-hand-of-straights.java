class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        Map<Integer, Integer> freq = new TreeMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(int i : freq.keySet()){
            while(freq.get(i) > 0){
                for(int j=0; j<k; j++){
                    if(freq.getOrDefault(j + i, 0) <= 0){
                        return false;
                    }
                    freq.put(i + j, freq.get(i + j) - 1);
                }
            }
        }
        return true;
    }
}