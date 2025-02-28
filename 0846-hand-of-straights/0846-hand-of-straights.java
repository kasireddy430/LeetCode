class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Base case: If hand.length is not multiple of groupSize, then we cannot form equal groups
        if(hand.length % groupSize != 0) return false;

        //Create TreeMap to count frequencies of each card and it will be in sorted order
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int num : hand){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //Process groups starting from the smallest available number
        while(!count.isEmpty()){
            //get the smallest card from treemap
            int small = count.firstKey();

            //Try to form groups of groupSize
            for(int i = small; i < small + groupSize; i++){
                //Return false if there is number missing, which indicates equal groups cannot be formed
                if(!count.containsKey(i)){
                    return false;
                }

                //Decrement the count frequency, since the card is used to form group
                count.put(i, count.get(i) - 1);
                //Remove vard from TreeMap if count reaches 0
                if(count.get(i)==0){
                    count.remove(i);
                }
            }
        }
        //Return true if exits the loop, indicating equal groups
        return true;
    }
}

//Time Complexity: O(n log n). Contributed by insertions into treeMap
//Space Complexity: O(n)