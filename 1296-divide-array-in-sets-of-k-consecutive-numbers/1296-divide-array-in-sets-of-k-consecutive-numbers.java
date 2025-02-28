class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;

        TreeMap<Integer, Integer> count = new TreeMap<>();

        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        while(!count.isEmpty()){
            int smallest = count.firstKey();

            for(int i = smallest; i < smallest + k; i++){
                if(!count.containsKey(i)) return false;

                count.put(i, count.get(i) - 1);
                if(count.get(i) == 0) count.remove(i);
            }
        }

        return true;
    }
}

//Time Complexity: O(n logn)
//Space Complexity: O(n)
//https://github.com/kasireddy430/LeetCode/blob/main/0846-hand-of-straights/0846-hand-of-straights.java