class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Count how many meetings each room handles
        int[] count = new int[n];
        // Track when each room will be free (end time of the last assigned meeting)
        long[] busy = new long[n];

        // Sort meetings by their start time (we must assign meetings in order)
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Process each meeting one by one
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            // Track the earliest finishing room (in case no room is free at "start")
            long earliest = Long.MAX_VALUE;
            int roomIndex = -1;
            boolean assigned = false;

            // Loop through all rooms to find one that can take this meeting
            for (int i = 0; i < n; i++) {
                // Always update the earliest finishing room
                if (busy[i] < earliest) {
                    earliest = busy[i];
                    roomIndex = i;
                }

                // If this room is free before or at the meeting start,
                // assign the meeting to it immediately
                if (busy[i] <= start) {
                    busy[i] = end;   // Update room’s "free time"
                    count[i]++;      // Increment number of meetings for this room
                    assigned = true; // Mark as assigned
                    break;           // No need to check other rooms
                }
            }

            // If no room was free at "start", we delay the meeting
            // and assign it to the room that becomes free the earliest.
            if (!assigned) {
                // Extend that room’s schedule by the meeting duration
                busy[roomIndex] += (end - start);
                count[roomIndex]++;
            }
        }

        // After all meetings, find the room with the maximum count
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}
