class Solution {
    public String arrangeWords(String text) {
        //Array of string's seperated by spaces
        String[] strs = text.split(" ");

        //Update first string to lower case
        strs[0] = strs[0].toLowerCase();

        //sort them based on their lengths
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        //update first charcter of first string to be upper case
        strs[0] = strs[0].substring(0, 1).toUpperCase() + strs[0].substring(1);

        //return sorted array as string
        return String.join(" ", strs).trim();

    }
}