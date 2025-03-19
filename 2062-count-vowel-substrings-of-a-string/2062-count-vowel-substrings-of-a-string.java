class Solution {
    public int countVowelSubstrings(String word) {
        int length = word.length();

        boolean[] vows = new boolean[128];//tracks vowel characters in input string

        vows['a'] = true;
        vows['e'] = true;
        vows['i'] = true;
        vows['o'] = true;
        vows['u'] = true;

        int[] count = new int[128];//tracks count of vowels
        int uniqueVows = 0;
        int currentBegin = 0;
        int begin = 0;
        int result = 0;

        for(int i = 0; i < length; i++){
            char c = word.charAt(i);

            if(vows[c]){
                count[c]++;

                if(count[c] == 1){
                    uniqueVows++;
                }

                //shrink window until all unique vowels are present
                while(uniqueVows == 5){
                    uniqueVows -= --count[word.charAt(begin)] == 0 ? 1 : 0;
                    begin++; 
                }
                result += begin - currentBegin;
                
            } else {
                //reset vowel counts
                if(uniqueVows != 0){
                    uniqueVows = 0;

                    count['a'] = 0;
                    count['e'] = 0;
                    count['i'] = 0;
                    count['o'] = 0;
                    count['u'] = 0;
                }
                currentBegin = begin = i + 1; 
            }
        }
        return result;
    }
}


//Time Complexity: O(n)
//Space Complexity: O(1)