class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backTrack(0, 0, n, stack, result);
        return result;
    }

    private void backTrack(int open, int closed, int n, StringBuilder stack, List<String> result){
        if(open == closed && open == n){
            result.add(stack.toString());
            return;
        }

        if(open < n){
            stack.append('(');
            backTrack(open + 1, closed, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(closed < open){
            stack.append(')');
            backTrack(open, closed + 1, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}

//TC: O(4 ^ n/sqrt(n));
//SC: O(n)