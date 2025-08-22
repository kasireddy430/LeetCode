class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = words.length;

        for(int i = n - 1; i >= 0; i--){
            sb.append(words[i]);

            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}