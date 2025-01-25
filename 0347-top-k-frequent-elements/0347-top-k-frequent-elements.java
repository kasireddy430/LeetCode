class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Create a hashmap to store the frequencies of integers from input array
        Map<Integer, Integer> count = new HashMap<>();

        //Create an array of list to group numbers based on their frequncies
        //index represent the frequency and each index holds the list of integers with index frequency 
        List<Integer>[] freq= new List[nums.length + 1];

        //Iterate over input array and count their frequncies
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //Initialize the frequency array list
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        //Populate the frequency array list with index representing the frequency and for that 
        //frequency populate the list of integers
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] result = new int[k];
        //Iterate over freq array list and populate the result array with 
        //top k frequent elements until result array's index reaches the k value 
        for(int i = freq.length - 1; i>=0 && index < k ; i--){
            for(int j : freq[i]){
                result[index++] = j;
                if(index == k){
                    return result;
                }
            }
        }
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)