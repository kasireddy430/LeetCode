class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    private Map<Integer, Integer> map = new HashMap<>();
    private int balance = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];

        for(int i = 0; i < k; i++){
            addNum(nums[i]);
        }

        res[0] = findMedian();

        for(int i = k; i < n; i++){
            removeNum(nums[i - k]);
            addNum(nums[i]);
            res[i - k + 1] = findMedian();
        }
        return res;    
    }

    private void addNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.offer(num);
            balance++;
        } else{
            minHeap.offer(num);
            balance--;
        }
    }

    private void removeNum(int num){
        map.merge(num, 1, Integer::sum);

        if(maxHeap.peek() >= num){
            balance--;
        } else{
            balance++;
        }
    }    

    private double findMedian(){
        balance();
        cleanUp(maxHeap);
        cleanUp(minHeap);

        return balance > 0 ? maxHeap.peek() : ((long)maxHeap.peek() + minHeap.peek())/2.0; 
    }

    private void cleanUp(PriorityQueue<Integer> heap){
        while(map.containsKey(heap.peek())){
            map.merge(heap.poll(), 1, (cur, diff) -> cur != 1 ? cur - diff : null);
        }
    }

    private void balance(){
        while(balance > 1){
            minHeap.offer(maxHeap.poll());
            balance -= 2;
        } 

        while(balance < 0){
            maxHeap.offer(minHeap.poll());
            balance += 2;
        }
    }
}

//Time Complexity: O()
//Space Complexity: O(k)