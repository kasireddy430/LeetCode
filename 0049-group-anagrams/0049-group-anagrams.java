class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
        }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m)
// Where m is the number of strings and n is the length of the longest string.
