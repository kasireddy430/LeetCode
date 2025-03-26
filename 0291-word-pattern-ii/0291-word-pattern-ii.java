class Solution {
    Map<Character, String> map;
    Set<String> revMap;
    public boolean wordPatternMatch(String pattern, String s) {
        map = new HashMap<>();
        revMap = new HashSet<>();
        return checkForPatter(pattern, s);
    }

    boolean checkForPatter(String pattern, String s) {
        if(pattern.isEmpty()) 
            return s.isEmpty();
        if(map.containsKey(pattern.charAt(0))) {
            if(s.startsWith(map.get(pattern.charAt(0)))) {
                return checkForPatter(pattern.substring(1), 
                s.substring(map.get(pattern.charAt(0)).length()));
            }
            else 
                return false;
        }
        for(int i=0;i<s.length();i++) {
            if(revMap.contains(s.substring(0,i+1)))
                continue;
            revMap.add(s.substring(0,i+1));
            map.put(pattern.charAt(0), s.substring(0,i+1));
            if(checkForPatter(pattern.substring(1), s.substring(i+1))) {
                return true;
            }
            revMap.remove(s.substring(0,i+1));
            map.remove(pattern.charAt(0));
        }
        return false;
    }


}