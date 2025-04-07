class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;
        int[] smallRange = new int[]{0, Integer.MAX_VALUE};

        for(int i = 0; i < nums.size(); i++){
            int val = nums.get(i).get(0);
            heap.offer(new int[]{val, i, 0});
            curMax = Math.max(curMax, val);
        }

        while(true){
            int[] cur = heap.poll();
            int curMin = cur[0], listIndex = cur[1], elemIndex = cur[2];

            if(curMax - curMin < smallRange[1] - smallRange[0]){
                smallRange[0] = curMin;
                smallRange[1] = curMax;
            }

            if(elemIndex + 1 < nums.get(listIndex).size()){
                int nextVal = nums.get(listIndex).get(elemIndex + 1);
                heap.offer(new int[]{nextVal, listIndex, elemIndex + 1});
                curMax = Math.max(curMax, nextVal);
            } else {
                break;
            }
        }

        return smallRange;
    }
}

//Time Complexity: O(n log k)
//Space Complexity: O(k)