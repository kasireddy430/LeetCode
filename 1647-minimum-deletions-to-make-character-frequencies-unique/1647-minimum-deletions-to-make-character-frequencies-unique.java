class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int res=0;
        HashSet<Integer> set=new HashSet<>();
        for(int fre:freq){
            while(fre>0 && set.contains(fre)){
                fre--;
                res++;
            }
            set.add(fre);
        }
        return res;
    }
}