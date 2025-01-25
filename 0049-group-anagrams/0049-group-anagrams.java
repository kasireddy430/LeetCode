class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Create a hashmap to store the list of anagram strings for a given key
        Map<String, List<String>> anagram = new HashMap<>();

        //Iterate over input array
        for(String str : strs){
            //Initialize a count array for count the characters frequencies
            int[] count = new int[26];

            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            //Convert character count array to a string and use it as a key
            String key = Arrays.toString(count);
            //Check if a given key does exists or not. If exists add the string to list of strings.
            //If not, compute an arrayList and then add the string for the given key
            anagram.putIfAbsent(key, new ArrayList<>());
            anagram.get(key).add(str);
        }
        //return the list of anagram's grouped 
        return new ArrayList<>(anagram.values());
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m)
// Where m is the number of strings and n is the length of the longest string.
