class Solution {
    public boolean isAnagram(String s, String t) {
        //Check if length of the the strings are same
        if(s.length() != t.length()){
            //If not they aren't anagram
            return false;
        }

        //Create a hashmap to count the frequencies of characters from the input string
        Map<Character, Integer> count = new HashMap<>();

        //Iterate over the input string
        for(int  i = 0; i < s.length(); i++){
            //Increment the character count if found in string s
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            //Decrement the character count if found in string t
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
        }

        //Iterate over the hashmap
        for(char c : count.keySet()){
            //Check if each character has 0 count frequency
            if(count.get(c) != 0){
                //If not it is not an anagram, so return false
                return false;
            }
        }

        //return true if both the strings have the same characters and their count frequencies
        return true;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)