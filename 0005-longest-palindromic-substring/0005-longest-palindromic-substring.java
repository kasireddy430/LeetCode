class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        String str = "";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    if(maxLen< j - i +1){
                        str = s.substring(i,j+1);
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return str;
    }
    public boolean isPalindrome(int i , int j,String s){
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;


    }

}