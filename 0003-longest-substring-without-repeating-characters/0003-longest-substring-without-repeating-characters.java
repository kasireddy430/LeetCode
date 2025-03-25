class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int longest = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1). since set can store atmost 95 ASCII character's