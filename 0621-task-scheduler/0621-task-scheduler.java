class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0, maxCount = 0;

        int[] counter = new int[128];

        for(char task : tasks){
            counter[task]++;
        }

        for(int i = 0; i < 128; i++){
            if(counter[i] > maxFreq){
                maxFreq = counter[i];
                maxCount = 1;
            } else if(counter[i] == maxFreq){
                maxCount++;
            }
        }


        int partitions = maxFreq - 1;
        int partitionLength = n - (maxCount - 1);
        int remainingElements = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, partitions * partitionLength - remainingElements);

        return tasks.length + idles;
    }
}

//Time Complexity:
//Space Complexity: