public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();

        wordList.add(beginWord);
        for(String word : wordList){
            for(int j = 0; j < word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(beginWord);
        visited.add(beginWord);
        int res = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String w = q.poll();

                if(w.equals(endWord)){
                    return res;
                }

                for(int j = 0; j < w.length(); j++){
                    String pattern = w.substring(0, j) + "*" + w.substring(j + 1);

                    for(String neiWord : adj.getOrDefault(pattern, new ArrayList<>())){
                        if(!visited.contains(neiWord)){
                            visited.add(neiWord);
                            q.offer(neiWord);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}

//TC: O(n * l ^ 2). l : length of word, n : no.of words
//SC: O(n * l)