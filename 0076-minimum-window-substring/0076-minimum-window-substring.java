class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        int matches = 0;
        int minWindow = Integer.MAX_VALUE;
        int l = 0, start = 0;

        for(int i = 0; i < t.length(); i++){
            char tChar = t.charAt(i);
            tCount.put(tChar, tCount.getOrDefault(tChar, 0) + 1);
        }

        System.out.println(tCount + "tCCCCC");
        for(int r = 0; r < s.length(); r++){
            char sChar = s.charAt(r);
            sCount.put(sChar, sCount.getOrDefault(sChar, 0) + 1);

            System.out.println(sCount + "sCCCCC");
            if(tCount.containsKey(sChar) && tCount.get(sChar) == sCount.get(sChar)){
                matches++;
            }
            System.out.println(matches + "hi");
            while(matches == t.length()){
                if(r - l + 1 < minWindow){
                    minWindow = r - l + 1;
                    start = l;
                }

                //Shrink window
                char shrink = s.charAt(l);
                sCount.put(shrink, sCount.getOrDefault(shrink, 0) - 1);

                if(tCount.containsKey(shrink) && sCount.get(shrink) < tCount.get(shrink)){
                    matches--;
                }
                l++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? "": s.substring(start, start + minWindow);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)