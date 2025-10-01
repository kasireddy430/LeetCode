class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for(String word : wordlist){
            String lower = word.toLowerCase();
            String deVowel = devowel(lower);
            lowerMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(deVowel, word);
        }

        int n = queries.length;
        String[] res = new String[n];

        for(int i = 0; i < n; i++){
            String val = queries[i];

            if(exact.contains(val)){
                res[i] = val;
            } else{
                String lower = val.toLowerCase();
                String deVowel = devowel(lower);

                if(lowerMap.containsKey(lower)){
                    res[i] = lowerMap.get(lower);
                } else if(vowelMap.containsKey(deVowel)){
                    res[i] = vowelMap.get(deVowel);
                } else{
                    res[i] = "";
                }
            }
        }

        return res;
    }

    private String devowel(String word){
        char[] charArr = word.toCharArray();

        for(int i = 0; i < charArr.length; i++){
            if(vowelCheck(charArr[i])) charArr[i] = '*';
        }

        return new String(charArr);
    }

    private boolean vowelCheck(char c){
        return "aeiou".indexOf(c) >= 0;
    }
}

//TC: O((W + Q) * L)
//SC: O(N * L)