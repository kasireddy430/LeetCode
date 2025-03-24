class Solution {
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, "");
    }

    private boolean helper(String s, List<String> wordDict, String newString){
        if(s.equals(newString)) return true;

        if(newString.length() > s.length() ||
            set.contains(newString) ||
            ! s.substring(0, newString.length()).equals(newString)){
                return false;
        }

        boolean ans = false;
        for(String word : wordDict){
            ans = ans || helper(s, wordDict, newString + word);
        }

        if(!ans) set.add(newString);

        return ans;
    }
}

//Time Complexity:
//Suppose there are n characters in s and m words in wordDict.
//The function may try O(n) prefixes, each taking O(m) recursive calls.
//So, in the worst case, it runs in O(n * m).

//Space Complexity: O(n) (due to recursion stack + HashSet storage)