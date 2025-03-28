class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.isEmpty() != abbr.isEmpty()) {
            return false;
        }

        if (word.isEmpty()) return true;

        if (word.charAt(0) == abbr.charAt(0)) {
            return validWordAbbreviation(word.substring(1), abbr.substring(1));
        }

        if (abbr.charAt(0) == '0' || !Character.isDigit(abbr.charAt(0))) {
            return false;
        }

        int count = 0, index = 0;

        while (index < abbr.length() && Character.isDigit(abbr.charAt(index))) {
            count = 10 * count + (abbr.charAt(index) - '0');
            index++;
        }

        if (count > word.length()) return false;

        return validWordAbbreviation(word.substring(count), abbr.substring(index));

    }
}