class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int l = 0;
        int longest = 0;
        int[] count = new int[26];
        int maxCount = 0;

        for(int r = 0; r < length; r++){
            int index = s.charAt(r) - 'A';
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);

            while(r - l + 1 - maxCount > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)