class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if(!a.getValue().equals(b.getValue())){
                    return a.getValue() - b.getValue();
                } else{
                    return b.getKey().compareTo(a.getKey());
                }
            }
        );

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            minHeap.offer(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while(!minHeap.isEmpty()){
            res.add(minHeap.poll().getKey());
        }

        Collections.reverse(res);

        return res;
    }
}

//TC: O(n logk)
//SC: O(n)