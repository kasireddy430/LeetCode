class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), map, res);

        return res;
    }

    private void backtrack(String digits, int index, StringBuilder val, 
                            Map<Character, String> map, List<String> res){
        if(index == digits.length()){
            res.add(val.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for(int i = 0; i < letters.length(); i++){
            val.append(letters.charAt(i));
            backtrack(digits, index + 1, val, map, res);
            val.deleteCharAt(val.length() - 1);
        }
    }    
}

//TC: O(n * 4 ^ n)
//SC: O(n * 4 ^ n) contributed by output list.