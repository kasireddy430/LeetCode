class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int matches = 0;
        int l = 0;

        for(int i = 0; i < s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(count1[i] == count2[i]){
                matches++;
            }
        }

        for(int i = s1.length(); i < s2.length(); i++){
            if(matches == 26){
                return true;
            }

            int newIndex = s2.charAt(i) - 'a';
            count2[newIndex]++;

            if(count2[newIndex] == count1[newIndex]){
                matches++;
            } else if(count2[newIndex] == count1[newIndex] + 1){
                matches--;
            }

            int oldIndex = s2.charAt(l) - 'a';
            count2[oldIndex]--;

            if(count2[oldIndex] == count1[oldIndex]){
                matches++;
            } else if(count2[oldIndex] + 1 == count1[oldIndex]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}

