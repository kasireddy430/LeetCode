class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }

        int oneBack = 1;
        int twoBack = 1;

        for(int i = 1; i < length; i++){
            int current = 0;

            if(s.charAt(i) != '0'){
                current = oneBack;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if(twoDigit >= 10 && twoDigit <= 26){
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)