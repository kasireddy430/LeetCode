import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String>[] freq = new List[words.length + 1];
        List<String> res = new ArrayList<>();

        // Step 1: Count frequencies
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Initialize all buckets
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: Fill the buckets
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            freq[count].add(entry.getKey());
        }

        // Step 4: Process buckets from high to low
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            if (!freq[i].isEmpty()) {
                Collections.sort(freq[i]); // Lexicographic sort
                for (String word : freq[i]) {
                    res.add(word);
                    index++;
                    if (index == k) return res;
                }
            }
        }

        return res;
    }
}
