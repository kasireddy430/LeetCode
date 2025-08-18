class TimeMap {

    Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> val = keyStore.getOrDefault(key, new ArrayList<>());

        int l = 0, r = val.size() - 1;
        String result = "";

        while(l <= r){
            int mid = l + (r - l)/2;

            if(val.get(mid).getKey() <= timestamp){
                result = val.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private class Pair<K, V>{
        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}

//TC: O(1) for set and O(log n) for get
//SC: O(m * n). where m - no.of keys and n - no.of values associated with keys

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */