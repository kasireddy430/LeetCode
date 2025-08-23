class Solution {
    public int minDeletions(String s) {
        int[] frequency = new int[26];

        for(char c : s.toCharArray()){
            frequency[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int freq : frequency){
            while(freq > 0 && set.contains(freq)){
                freq--;
                res++;
            }
            set.add(freq);
        }
        return res;
    }
}

//TC: O(n)
//SC: O(1)