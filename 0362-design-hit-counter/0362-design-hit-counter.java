class HitCounter {

    Queue<Integer> timeQueue;

    public HitCounter() {
        timeQueue = new LinkedList();
    }
    
    public void hit(int timestamp) {
        timeQueue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!timeQueue.isEmpty() && timeQueue.peek() + 300 <= timestamp){
            timeQueue.poll();
        }

        return timeQueue.size();
    }
}

//Time Complexity: O(1) for hit and O(n) for getHits since it might remove n elements
//Space Complexity: O(n)

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */