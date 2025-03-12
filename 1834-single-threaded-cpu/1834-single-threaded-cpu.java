class Solution {
    class Task {
        int index;
        int start;
        int duration;
        Task(int index_, int start_, int duration_) {
            index = index_;
            start = start_;
            duration = duration_;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.duration == b.duration ? (a.index - b.index) : a.duration - b.duration);
        int listIndex = 0;
        int[] ans = new int[tasks.length];
        int count = 0;
        int time = 0;
        while (count < ans.length) {
            while (listIndex < tasks.length && list.get(listIndex).start <= time) {
                pq.add(list.get(listIndex));
                listIndex++;
            }
            if (pq.isEmpty()) {
                time = list.get(listIndex).start;
                continue;
            }
            Task task = pq.poll();
            ans[count++] = task.index;
            time += task.duration;
        }
        return ans;
    }
}