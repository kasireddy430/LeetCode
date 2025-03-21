class HitCounter {

    Queue<Integer> timeQueue;

    public HitCounter() {
        timeQueue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        timeQueue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        if(timestamp <= 300) {
            return timeQueue.size();
        }
        while(!timeQueue.isEmpty() && timeQueue.peek() <= timestamp - 300) timeQueue.poll();
        return timeQueue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */