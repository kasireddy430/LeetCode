public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;

        //Sum(i, j) should equal k. so prefix[j] - prefix[i - 1] = k -> 
        //prefix[j] - k = prefix[i - 1];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

//TC: O(n)
//SC: O(n)