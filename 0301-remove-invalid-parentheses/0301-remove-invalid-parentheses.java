class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private void remove(String s, List<String> result, int lastCheckIndex, int lastRemovedIndex, char[] par){
        int balance = 0;

        for(int i = lastCheckIndex; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == par[0]) balance++;
            if(c == par[1]) balance--;

            if(balance >= 0) continue;

            for(int j = lastRemovedIndex; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == lastRemovedIndex || s.charAt(j - 1) != par[1])){
                    remove(s.substring(0, j) + s.substring(j + 1), result, i, j, par);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        if(par[0] == '('){
            remove(reversed, result, 0, 0, new char[]{')', '('});
        } else {
            result.add(reversed);
        }
    }
}