class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")){
            return -1;
        } 

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer("0000");
        visited.add("0000");
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String cur = q.poll();

                if(cur.equals(target)){
                    return level;
                }

                for(String next : getNextState(cur)){
                    if(!set.contains(next) && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                } 
            }
            level++;
        }

        return -1;
    }

    private List<String> getNextState(String cur){
        List<String> res = new ArrayList<>();
        char[] c = cur.toCharArray();

        for(int i = 0; i < 4; i++){
            char original = c[i]; 

            c[i] = (original == '9') ? '0' : (char)(original + 1);
            res.add(new String(c));

            c[i] = (original == '0') ? '9' : (char)(original - 1);
            res.add(new String(c));

            c[i] = original;
        }

        return res;
    }
}