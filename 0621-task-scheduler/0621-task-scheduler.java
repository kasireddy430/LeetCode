

//Time Complexity: O(N + 26 log 26) where N is the number of tasks. Counting frequencies is O(N), and sorting the 26 frequencies is effectively constant time, so it's approximately O(1). Overall, it's dominated by the O(N) component. Space Complexity: O(1) since the space used for the frequencies array is constant, regardless of the input size.
//Time Complexity: O(n) Counting frequencies: O(n) We iterate through the tasks array once, where n is the number of tasks. Sorting frequencies: O(1) We sort an array of fixed size (26), which is constant regardless of input size. Sorting 26 elements can be considered O(1) as it doesn't grow with input. Calculating idle time and result: O(1) We perform a fixed number of operations and a loop that runs at most 26 times. The dominant factor is the initial counting of frequencies, making the overall time complexity O(n). Space Complexity: O(1) We use a fixed-size array (26 elements) for frequencies. All other variables use constant space. The space used doesn't grow with the input size. Why this solution is efficient: Single Pass Counting: It counts task frequencies in a single pass through the input array. Constant Space: It uses a fixed-size array for frequency counting, regardless of input size. Avoiding Simulation: Instead of simulating the actual scheduling process, it calculates the result mathematically. Greedy Approach: It focuses on the most frequent task and then accounts for other tasks, which is optimal for this problem. Minimal Sorting: It sorts only a small, fixed-size array (26 elements), which is very fast. Efficient Idle Time Calculation: It calculates idle time by considering only the necessary factors, avoiding unnecessary computations. Direct Result Calculation: The final step directly calculates the result without needing to build the actual schedule.
// Algorithm Type Greedy Algorithm: The algorithm uses a greedy approach to minimize idle time by filling the maximum possible slots with the most frequent tasks and then adjusting the idle time based on the remaining tasks.
// Why It's Efficient The algorithm efficiently counts task frequencies and uses sorting to prioritize the most frequent tasks. It calculates the minimum required idle time and adjusts for the remaining tasks, ensuring that it computes the least time required to complete all tasks while respecting the cooldown constraint. The approach scales linearly with the number of tasks, making it suitable for large inputs.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0, maxCount = 0;

        int[] counter = new int[128];
        for (char t : tasks) {
            counter[t]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > maxFreq) {
                maxFreq = counter[i];
                maxCount = 1;
            } else if (counter[i] == maxFreq) {
                maxCount++;
            }
        }

        int parts = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int leftElements = tasks.length - maxCount * maxFreq;
        int idles = Math.max(0, parts * partLength - leftElements);

        return tasks.length + idles;

    }
}