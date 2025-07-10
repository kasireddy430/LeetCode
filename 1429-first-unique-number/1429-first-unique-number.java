class FirstUnique {
    
    Map<Integer, Integer> map;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for(int num : nums){
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while(!queue.isEmpty() && map.containsKey(queue.peek()) && map.get(queue.peek()) > 1)
            queue.remove();
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if(!map.containsKey(value)){
            map.put(value, 1);
            queue.add(value);
        }else
            map.put(value, map.get(value) + 1);
    }
}