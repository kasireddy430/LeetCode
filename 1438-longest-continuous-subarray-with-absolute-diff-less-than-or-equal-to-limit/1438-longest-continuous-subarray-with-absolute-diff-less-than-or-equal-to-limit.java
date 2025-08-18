class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        int r = 0;
        int l = 0, longest = 0;

        while(r < nums.length){
            while(!max.isEmpty() && max.getLast() < nums[r]){
                max.removeLast();
            }

            max.addLast(nums[r]);

            while(!min.isEmpty() && min.getLast() > nums[r]){
                min.removeLast();
            }

            min.addLast(nums[r]);

            while((max.getFirst() - min.getFirst()) > limit){
                if(max.getFirst() == nums[l]){
                    max.removeFirst();
                }

                if(min.getFirst() == nums[l]){
                    min.removeFirst();
                }

                l++;
            }

            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}

//TC : O(n)
//SC : O(n)