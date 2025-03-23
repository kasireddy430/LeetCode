class Solution {
        Queue<Integer> queue = new LinkedList<>();

        public Solution(int[] w) {
            int sum = 0;
            
            for (int num : w) sum += num;

            for (int i = 0; i < w.length; i++) {
                for (int j = 0; j < ((w[i]*100)/sum); j++) queue.add(i);
            }
        }

        public int pickIndex() {
            if(queue.isEmpty()) return 0;
            int num = queue.poll();
            queue.add(num);
            return num;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */