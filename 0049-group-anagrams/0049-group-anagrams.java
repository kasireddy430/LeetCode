class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grpAnagrams = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];

            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            grpAnagrams.computeIfAbsent(key, k -> new ArrayList<>());
            grpAnagrams.get(key).add(s);
        }
        return new ArrayList<>(grpAnagrams.values());
    }
}