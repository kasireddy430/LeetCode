class Solution {
    public int minSteps(String s, String t) {
        //Create fixed size array to count character frequencies difference
        int[] count = new int[26];

        //count the character frequencies difference in s and t strings
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        int res = 0;
        //Iterate through count array to count the no.of
        //characters in t that needs to be replaced to make t and s strings anagram
        for(int i = 0; i < 26; i++){
            res += Math.max(0, count[i]);
        }

        return res;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)(fixed count array size)