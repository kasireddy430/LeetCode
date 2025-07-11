class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
            (a, b) -> {
                if (! a.getValue().equals(b.getValue())) {
                    return a.getValue() - b.getValue();
                } else {
                    return b.getKey().compareTo(a.getKey());
                }
            }
        );

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            q.offer(entry);

            if(q.size() > k){
                q.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while(!q.isEmpty()){
            res.add(q.poll().getKey());
        }

        Collections.reverse(res);

        return res;
    }
}

//TC: O(n logk)
//SC: O(n)