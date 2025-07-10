class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> count = new Stack<>();
        char[] sa = s.toCharArray();
        int j = 0;

        for(int i = 0; i < s.length(); i++, j++){
            sa[j] = sa[i];
            if(j == 0 || sa[j] != sa[j - 1]){
                count.push(1);
            } else{
                int incremented = count.pop() + 1;

                if(incremented == k){
                    j = j - k;
                } else {
                    count.push(incremented);
                }
            }
        }

        return new String(sa, 0 , j);
    }
}

//TC: O(n)
//SC: O(n)