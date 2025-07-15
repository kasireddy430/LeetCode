class Solution {
    public List<Boolean> getResults(int[][] queries) {
        TreeMap<Integer, Integer> obstacles = new TreeMap<>();

        List<Boolean> ans = new ArrayList<>();

        for(int[] q : queries){
            if(q[0] == 1){
                int index = q[1];

                Integer prev = obstacles.lowerKey(index);
                Integer next = obstacles.higherKey(index);

                if(prev == null){
                    obstacles.put(index, index);
                } else {
                    obstacles.put(index, Math.max(index - prev, obstacles.get(prev)));
                }

                prev = index;

                while(next != null && obstacles.get(next) > obstacles.get(prev)){
                    obstacles.put(next, Math.max(next - prev, obstacles.get(prev)));
                    prev = next;
                    next = obstacles.higherKey(next);
                }
            } else {
                int index = q[1], sz = q[2];

                if(obstacles.containsKey(index)){
                    ans.add(obstacles.get(index) >= sz);
                } else {

                    Integer prev = obstacles.lowerKey(index);

                    if(prev == null){
                        ans.add(index >= sz);
                    } else {
                        ans.add(Math.max(index - prev, obstacles.get(prev)) >= sz);
                    }
                }
            }
        }

        return ans;
    }

}