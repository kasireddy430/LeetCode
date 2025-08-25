class Solution {
    public String removeDigit(String s, char digit) {
        int n = s.length();
        String res = "";
        for(int i=0; i<n; i++){
            if(s.charAt(i)==digit){
                String t = s.substring(0,i)+s.substring(i+1);
                if(t.compareTo(res)>0){
                    res = t;
                }
            }      
        }
        
        return res;
    }

}