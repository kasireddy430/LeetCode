class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int l = 0, r = 0;

        while(r < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }

            q.addLast(r);

            if(q.getFirst() < l){
                q.removeFirst();
            }

            if(r - l + 1 >= k){
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}