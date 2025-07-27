class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(0, s, part, res);
        return res;
    }

    private void backtrack(int index, String s, List<String> part, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j = index; j < s.length(); j++){
            if(isPali(s, index, j)){
                part.add(s.substring(index, j+1));
                backtrack(j + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}

//TC: O(n * 2^n)
//SC: O(n * 2^n)