class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }

        Map<Character, Integer> tcount = new HashMap<>();
        Map<Character, Integer> scount = new HashMap<>();
        int matches = 0;
        int l = 0, start = 0;
        int minWindow = Integer.MAX_VALUE;

        for(int i = 0; i < t.length(); i++){
            tcount.put(t.charAt(i), tcount.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            scount.put(s.charAt(r), scount.getOrDefault(s.charAt(r), 0) + 1);

            if(tcount.containsKey(c) && scount.get(c).equals(tcount.get(c))){
                matches++;
            }

            while(matches == tcount.size()){

                if(r - l + 1 < minWindow){
                    minWindow = r - l + 1;
                    start = l;
                }

                char shrink = s.charAt(l);
                scount.put(shrink, scount.get(shrink) - 1);

                if(tcount.containsKey(shrink) && scount.get(shrink) < tcount.get(shrink)){
                    matches--;
                }
                l++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);
    }
}
