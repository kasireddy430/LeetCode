class KthLargest {
    //Create a priorityQueue to store k largest elements
    PriorityQueue<Integer> minHeap;
    private int k;

    //Constructor to initialize the object with k and the stream of test scores nums. 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        //iterate over input array and add them to priorityQueue
        for(int num:nums){
            minHeap.offer(num);

            //Check if minHeap size exceeds k value
            if(minHeap.size() > k){
                //If so, remove the smallest element from minHeap.
                //Such that minHeap store k largest elements.
                minHeap.poll();
            }
        }
    }

    //Method to add the given value to priorityQueue and
    //return kth largest element
    public int add(int val) {
        minHeap.offer(val);

        //Check if minHeap exceeds the threshold
        if(minHeap.size() > k){
            //If so remove the smallest element
            //Such that minHeap stores k largest elements even after adding a new value to stream
            minHeap.poll();
        }

        //return the kth largest element
        return minHeap.peek();
    }
}


//Time Complexity: O(n logk). logK is offered by offer()
//Space Complexity:O(k)

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */