public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If total number of cards is not divisible by groupSize, it's impossible to divide them evenly
        if (hand.length % groupSize != 0) return false;

        // Map to count frequency of each card
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Try to form groups from each card in the hand
        for (int num : hand) {
            int start = num;

            // Move backward to find the lowest consecutive number that still has a count
            while (count.getOrDefault(start - 1, 0) > 0) start--;

            // Try forming groups starting from this 'start' value up to 'num'
            while (start <= num) {

                // While the current start card still has unused copies
                while (count.getOrDefault(start, 0) > 0) {
                    // Attempt to build a full group of size groupSize starting from 'start'
                    for (int i = start; i < start + groupSize; i++) {
                        // If any card in the sequence is missing, return false
                        if (count.getOrDefault(i, 0) == 0) return false;
                        // Otherwise, reduce its count
                        count.put(i, count.get(i) - 1);
                    }
                }

                // Move to next potential group start
                start++;
            }
        }

        // All cards have been used in valid groups
        return true;
    }
}

//Time Complexity: O(n log n). Contributed by insertions into treeMap
//Space Complexity: O(n)