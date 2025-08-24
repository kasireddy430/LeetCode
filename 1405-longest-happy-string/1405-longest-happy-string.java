class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if(a > 0) q.offer(new int[]{a, 'a'});
        if(b > 0) q.offer(new int[]{b, 'b'});
        if(c > 0) q.offer(new int[]{c, 'c'});

        while(!q.isEmpty()){
            int[] first = q.poll();
            char char1 = (char)first[1];

            if(sb.length() > 1 && sb.charAt(sb.length() - 1) == char1 && sb.charAt(sb.length() - 2) == char1){
                if(q.isEmpty()) break;
                int[] second = q.poll();
                char char2 = (char)second[1];

                sb.append(char2);
                second[0]--;
                if(second[0] > 0) q.offer(second);
                q.offer(first);
            } else {
                sb.append(char1);
                first[0]--;
                if(first[0] > 0) q.offer(first);
            }
        }

        return sb.toString();
    }
}

//TC: O(n)
//SC: O(n) contributed by output string