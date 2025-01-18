class KthLargest {
    //Priority queue to store k largets elements
    private PriorityQueue<Integer> minHeap;
    private int k;

    //Initilize constructor with k and populate minheap with the input array values
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int num : nums){
            //Add elements from input array to the stream
            minHeap.offer(num);

            //Check if the minHeap exceeds the k
            if(minHeap.size() > k){
                //If so remove the smallest element from the heap
                minHeap.poll();
            }
        }
    }
    
    //Method to add the provided input value and remove the smallest element from the stream
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        //return the kth larget element if the stream isn't empty
        return minHeap.isEmpty()?0:minHeap.peek();
    }
}


//Time Complexity: O(n logk). logK is offered by offer()
//Space Complexity:O(k)

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */