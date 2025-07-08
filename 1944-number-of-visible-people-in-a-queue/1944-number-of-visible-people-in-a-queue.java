class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--) {
            int cnt = 0;
            while(!st.isEmpty() && st.peek() < heights[i]) {
                cnt++;
                st.pop();
            }

            if (!st.isEmpty())
                cnt++;
            ans[i] = cnt;
            st.push(heights[i]);
        }
        return ans;
    }
}