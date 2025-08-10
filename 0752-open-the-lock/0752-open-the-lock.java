class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return level;

                for (String next : getNextStates(curr)) {
                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private List<String> getNextStates(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Rotate up
            chars[i] = (original == '9') ? '0' : (char)(original + 1);
            result.add(new String(chars));

            // Rotate down
            chars[i] = (original == '0') ? '9' : (char)(original - 1);
            result.add(new String(chars));

            // Restore
            chars[i] = original;
        }

        return result;
    }
}