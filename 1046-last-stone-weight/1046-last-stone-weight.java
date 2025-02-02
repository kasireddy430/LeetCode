class Solution {
    public int lastStoneWeight(int[] stones) {
        //Create a priorityQueue to store stone weights in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //Iterate over input array and populate queue with input elements
        for(int stone : stones){
            maxHeap.offer(stone);
        }

        //Iterate until maxHeap has more than one element in it
        while(maxHeap.size() > 1){
            //Retrive top two elements from queue
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            //Check if both weights are same or not
            if(firstStone != secondStone){
                //If not same, calculate difference weight and add it to the queue
                maxHeap.offer(firstStone - secondStone);
            }
        }

        //If the queue isn't empty return the sole remaining element. If not, return 0.
        return maxHeap.isEmpty()? 0 : maxHeap.peek();
    }
}

//Time Complexity: O(n log n). log n is contributed by offer().
//Space Complexity: O(n)