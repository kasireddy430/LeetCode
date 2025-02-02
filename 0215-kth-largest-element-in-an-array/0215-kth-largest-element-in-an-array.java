class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Create a priorityQueue to store k largest points
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //Iterate over input array and add them to the queue
        for(int num : nums){
            minHeap.offer(num);

            //if queue size exceeds the k value, remove the smalles elements from the q
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        // return kth largest element from queue
        return minHeap.peek();
    }
}

//Time Complexity: O(n log k)
//Space Complexity: O(k)