class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pointer1 = 0;
        int pointer2 = 0;
        int abbrNum = 0;

        while (pointer2 < abbr.length()) {
            if (Character.isDigit(abbr.charAt(pointer2))) {
                // update the num in abbr
                abbrNum = abbrNum * 10 + abbr.charAt(pointer2) - '0';
                // checking the leading zero or empty substring
                if (abbrNum == 0) {
                    return false;
                }
                pointer2++;
            } else {
                // skip substrings and check validation
                pointer1 += abbrNum;
                if (pointer1 >= word.length()) {
                    return false;
                }
                abbrNum = 0;

                // check current char
                if (word.charAt(pointer1) == abbr.charAt(pointer2)) {
                    pointer1++;
                    pointer2++;
                } else {
                    return false;
                }
            } 
        }
    
        return pointer1 + abbrNum == word.length();
    }
}