class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wLen = word.length();
        int aLen = abbr.length();

        if(aLen > wLen){
            return false;
        }

        

        int i = 0, j = 0;
        while(i < wLen && j < aLen){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }

            if(abbr.charAt(j) == '0' || !Character.isDigit(abbr.charAt(j))){
                return false;
            }

            int num = 0;

            while(j < aLen && Character.isDigit(abbr.charAt(j))){
                num = num * 10 + (abbr.charAt(j) - '0');
                j++;
            }

            i += num;
        }

        return i == wLen && j == aLen;
    }
}

/**
 * Time Complexity: O(A)
 * Space Complexity: O(1)
 * A = Length of abbr input string.
 */