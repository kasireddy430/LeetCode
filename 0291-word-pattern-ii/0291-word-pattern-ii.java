class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrack(0, 0, pattern, s, new HashMap<>(), new HashSet<>());
    }

    private boolean backtrack(int i, int j, String pattern, String s, Map<Character, String> map,
                            Set<String> vals){

        if(i >= pattern.length() && j >= s.length()){
            return true;
        }
        
        if(i >= pattern.length() || j >= s.length()){
            return false;
        }

        if(map.containsKey(pattern.charAt(i))){
            String expectedWord = map.get(pattern.charAt(i));

            if(!s.startsWith(expectedWord, j)){
                return false;
            }

            return backtrack(i + 1, j + expectedWord.length(), pattern, s, map, vals);
        }

        for(int k = j; k < s.length(); k++){
            String value = s.substring(j, k+1);
            if(vals.contains(value)) continue;

            map.put(pattern.charAt(i), value);
            vals.add(value);

            //recur for next character in pattern and next substring in s
            if(backtrack( i + 1, k + 1, pattern, s, map, vals)){
                return true;
            }

            //backtracking if not found valid
            map.remove(pattern.charAt(i));
            vals.remove(value);        
        }
        return false;
    }
}

//Time Complexity: O(2 ^ n)
//Space Complexity: O(n)