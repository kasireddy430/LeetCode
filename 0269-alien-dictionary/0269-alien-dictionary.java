class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                map.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))){
                return "";
            }

            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!map.get(w1.charAt(j)).contains(w2.charAt(j))){
                        map.get(w1.charAt(j)).add(w2.charAt(j));
                        inDegree.put(w2.charAt(j), inDegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for(char ch : inDegree.keySet()){
            if(inDegree.get(ch) == 0){
                q.offer(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()){
            char _ch = q.poll();

            res.append(_ch);

            for(char c : map.get(_ch)){
                inDegree.put(c, inDegree.get(c) - 1);

                if(inDegree.get(c) == 0){
                    q.offer(c);
                }
            }
        }

        if(res.length() != inDegree.size()){
            return "";
        }

        return res.toString();
    }
}
