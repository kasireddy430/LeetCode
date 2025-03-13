class Solution {

    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private int balance;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var res = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }

        res[0] = findMedian();

        for (int i = k; i < n; i++) {
            removeNum(nums[i - k]);
            addNum(nums[i]);

            res[i - k + 1] = findMedian();
        }

        return res;
    }

    private void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.offer(num);
            balance++;
        } else {
            minHeap.offer(num);
            balance--;
        }
    }

    private void removeNum(int num) {
        map.merge(num, 1, Integer::sum);

        if (maxHeap.peek() >= num) {
            balance--;
        } else {
            balance++;
        }
    }

    private double findMedian() {
        balance();
        cleanHeap(maxHeap);
        cleanHeap(minHeap);

        // balance();

        return balance > 0 ? maxHeap.peek() : ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    private void cleanHeap(PriorityQueue<Integer> heap) {
        while (map.containsKey(heap.peek())) {
            map.merge(heap.poll(), 1, (curr, diff) -> curr != 1 ? curr - diff : null);
        }
    }

    private void balance() {
        while (balance > 1) {
            minHeap.offer(maxHeap.poll());
            balance -= 2;
        }
        while (balance < 0) {
            maxHeap.offer(minHeap.poll());
            balance += 2;
        }
    }
}