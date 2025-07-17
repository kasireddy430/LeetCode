class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s.length() > 12 || s.length() < 4){
            return res;
        }

        backtrack(s, 0, 0, "", res);

        return res;
    }

    private void backtrack(String s, int i, int dots, String curString, List<String> res){
        if(dots == 4 && i == s.length()){
            res.add(curString.substring(0, curString.length() - 1));
            return;
        }

        if(dots >= 4){
            return;
        }

        for(int j = i; j < i + 3 && j < s.length(); j++){
            String segment = s.substring(i, j + 1);
            if(isValidSegment(segment)){
                backtrack(s, j + 1, dots + 1, curString + segment + ".", res);;
            }
        }
    }

    private boolean isValidSegment(String cur){
        if(cur.length() > 1 && cur.startsWith("0")){
            return false;
        }
        int val = Integer.parseInt(cur);
        return val >= 0 && val <= 255; 
    }
}

//Time Complexity: O(1) . O(3 ^ 4)
//SC: O(1)