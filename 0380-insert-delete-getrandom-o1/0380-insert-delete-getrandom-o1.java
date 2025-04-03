class RandomizedSet {
    List<Integer> listSet;
    Map<Integer, Integer> map;
    
    public RandomizedSet() {
        listSet = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        listSet.add(val);
        map.put(val, listSet.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        
        int idx = map.get(val); // Index of the element to remove
        int lastElement = listSet.get(listSet.size() - 1); // Last element

        // Swap the element to be removed with the last element
        listSet.set(idx, lastElement);
        map.put(lastElement, idx);

        // Remove the last element
        listSet.remove(listSet.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int) (Math.random() * listSet.size());
        return listSet.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
