class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String , Integer> map = new TreeMap<>();
        for(String word:words){
            map.put(word , map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:map.values()){
            maxheap.add(n);
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=k;++i){
            int n = maxheap.poll();
            String str = findword(map , n);
            map.remove(str);
            list.add(str);
        }
        return list;

    }
    public String findword(TreeMap<String ,Integer> map , int n){
        for(String s:map.keySet()){
            if(map.get(s)==n){
                return s;
            }
        }
        return " ";
    }
}