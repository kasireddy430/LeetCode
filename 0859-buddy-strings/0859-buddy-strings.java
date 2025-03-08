class Solution {
    public boolean buddyStrings(String s, String goal) {
        // If lengths don't match, they can never be buddy strings
        if (s.length() != goal.length()) return false;

        // Case 1: If strings are identical, check for duplicate characters
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) return true; // Duplicate character found
            }
            return false; // No duplicate characters, cannot swap same letter
        }

        // Case 2: Find positions where the characters differ
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        // There must be exactly 2 differences, and swapping them should fix the mismatch
        return diff.size() == 2 && 
               s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) &&
               s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}
