class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void dfs(String s, List<String> res, int lastCheckIndex, int lastRemoveIndex, char[] par){
        int balance = 0;

        for(int i = lastCheckIndex; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == par[0]) balance++;
            if(c == par[1]) balance--;

            if(balance >= 0) continue;

            for(int j = lastRemoveIndex; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == lastRemoveIndex || s.charAt(j - 1) != par[1])){
                    dfs(s.substring(0, j) + s.substring(j + 1), res, i, j, par);
                }
            }
            return;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(par[0] == '('){
             dfs(reverse, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(reverse);
        }
    }
}

//Time Complexity: O(2 ^ n)
//Space Complexity: O(2 ^ n)