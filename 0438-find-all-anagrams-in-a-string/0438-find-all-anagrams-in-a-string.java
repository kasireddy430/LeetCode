class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sAlphabet = new int[26];
        int[] pAlphabet = new int[26];

        List<Integer> answer = new ArrayList<>();
        if(p.length() > s.length()) return answer;
        int i, curr = 0;
        for(i = 0; i < p.length()-1; i++) {
            sAlphabet[s.charAt(i)-'a']++;
            pAlphabet[p.charAt(i)-'a']++;
        }
        pAlphabet[p.charAt(i)-'a']++;
        for(int j = i; j < s.length(); j++) {
            sAlphabet[s.charAt(j)-'a']++;
            boolean isValid = false;
            for(int x = 0; x < 26; x++) {
                if(sAlphabet[x] != pAlphabet[x]) {
                    isValid = true;
                    break;
                }
            }
            if(!isValid) answer.add(curr);
            sAlphabet[s.charAt(curr++)-'a']--;
        }
        return answer;
    }
}