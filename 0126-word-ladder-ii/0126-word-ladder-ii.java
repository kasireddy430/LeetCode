class Solution {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> adjList = new HashMap<>();
    Map<String, Integer> dist = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;

        dist.put(beginWord, 0);
        q.offer(beginWord);
        while (!q.isEmpty()) {
            String curWord = q.poll();
            visited.add(curWord);
            if (curWord.equals(endWord)) break;
            getNeighbors(curWord, wordSet);
        }
        if (!dist.containsKey(endWord)) return res;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, path);
        return res;
    }

    private void getNeighbors(String word, Set<String> wordSet) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String nextWord = new String(chars);
                chars[i] = oldChar;
                if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                    if (!dist.containsKey(nextWord)) {
                        dist.put(nextWord, dist.get(word) + 1);
                        q.offer(nextWord);
                    }
                    if (dist.get(nextWord) == dist.get(word) + 1) {
                        adjList.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);
                    }
                }
            }
        }
    }

    private void backtrack(String cur, String begin, List<String> path) {
        if (cur.equals(begin)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!adjList.containsKey(cur)) return;

        for (String prev : adjList.get(cur)) {
            path.add(0, prev);
            backtrack(prev, begin, path);
            path.remove(0);
        }
    }
}