class KthLargest {
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>();

        for(int num : nums){
            q.offer(num);

            if(q.size() > k){
                q.poll();
            }
        } 
    }

    public int add(int val) {
        q.offer(val);

        if(q.size() > k){
            q.poll();
        }
        return q.peek();
    }
}


//Time Complexity: O(n logk). logK is offered by offer()
//Space Complexity:O(k)
//Where k is the size of heap and n is number of elements in the array


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */