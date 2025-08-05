public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        while (!count.isEmpty()) {
            int start = count.firstKey(); // always take the smallest number

            for (int i = start; i < start + groupSize; i++) {
                if (!count.containsKey(i)) return false;
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    count.remove(i);
                }
            }
        }

        return true;
    }
}
