class Solution {
    public int lastStoneWeight(int[] stones) {
        //Create a priorityqueue to hold stone weights in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //Iterate over input array and populate priority queue
        for(int stone:stones){
            maxHeap.offer(stone);
        }

        //simulate breaking the stones
        while(maxHeap.size() > 1){
            //Destroy the heaviest two stones
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            //Check if the weights of both the stones are same
            if(first != second){
                //if not, add a new weight 
                maxHeap.offer(first - second);
            }
        }

        //returnthe last stone weight if the queue is not empty
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}

//Time Complexity: O(n log n). log n is contributed by offer().
//Space Complexity: O(n)