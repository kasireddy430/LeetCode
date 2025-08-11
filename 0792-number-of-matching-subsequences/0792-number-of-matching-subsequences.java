class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(String word : map.keySet()){
            if(word.length() > s.length()){
                continue;
            }

            int j = 0;
            for(int i = 0; i < s.length() && j < word.length(); i++){
                if(word.charAt(j) == s.charAt(i)){
                    j++;
                }
            }

            if(j == word.length()){
                ans += map.get(word);
            }
        }

        return ans;
    }
}

//TC: O(s * w)
//SC: O(w)