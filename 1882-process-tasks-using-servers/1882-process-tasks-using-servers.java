class Solution {
    public int[] assignTasks(final int[] servers, final int[] tasks) {
        // Min-heap of available servers: [weight, index]
        Queue<int[]> available = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // Min-heap of used servers: [nextFreeTime, index]
        Queue<int[]> used = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] result = new int[tasks.length];

        for(int i = 0; i < servers.length; i++){
            available.offer(new int[]{servers[i], i});
        }

        int i = 0, time = 0;

        while(i < tasks.length){
            if(available.isEmpty()){
                time = used.peek()[0];
            }

            while(!used.isEmpty() && used.peek()[0] <= time){
                int usedServerID = used.poll()[1];
                available.offer(new int[]{servers[usedServerID], usedServerID});
            }

            while(i < tasks.length && !available.isEmpty() && i <= time ){
                int id = available.poll()[1];

                used.offer(new int[]{time + tasks[i], id});
                result[i] = id;
                i++;
            }
            time++;
        }

        return result;
    }
}