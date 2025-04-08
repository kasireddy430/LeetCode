class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // visited map
        Map<String, Boolean> wordMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word, false);
        }

        LinkedList<List<String>> res = new LinkedList<>();

        if (!wordMap.containsKey(endWord)) return res;

        List<List<String>> levelList = new ArrayList<>();
        boolean isSuccess = buildLevel(beginWord, endWord, wordMap, levelList);

        if (!isSuccess) return res;

        List<String> path = new LinkedList<>();
        path.add(endWord);
        res.add(path);

        for (int i = levelList.size() - 1; i >= 0; i--) {
            List<String> curLevel = levelList.get(i);
            int size = res.size();
            while (size-- > 0) {
                List<String> road = res.poll();
                String w = road.get(0);
                for (String levelWord : curLevel) {
                    if (!beNext(levelWord, w)) continue;
                    LinkedList<String> newPath = new LinkedList<>(road);
                    newPath.addFirst(levelWord);
                    res.offer(newPath);
                }
            }
        }
        return res;


    }

    private boolean buildLevel(String beginWord, String endWord, Map<String, Boolean> wordMap, List<List<String>> levelList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordMap.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> curLevel = new ArrayList<>();

            while (size-- > 0) {
                String word = queue.poll();
                curLevel.add(word);

                if (word.equals(endWord)) return true;
                for (String key : wordMap.keySet()) {
                    if (wordMap.get(key) || !beNext(word, key)) continue;
                    queue.offer(key);
                    wordMap.put(key, true);
                }
            }
            levelList.add(curLevel);
        }

        return false;
    }

    private boolean beNext(String a, String b) {
        int diff = 0;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        for (int i = 0; i < a.length() && diff < 2; i++) {
            if (arrA[i] != arrB[i]) diff++;

        }
        return diff == 1;
    }
}