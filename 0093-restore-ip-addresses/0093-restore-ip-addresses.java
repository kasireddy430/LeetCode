class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        helper(s,ans,0,new ArrayList<>());
        return ans;
    }
    public static void helper(String s,List<String> ans,int idx,List<String> temp){
        if(temp.size()>4){
            return;
        }
        if(idx==s.length() && temp.size()==4){
            //for(int j=0;j<temp.size();j++){
            //    sb.append(temp.get(j)).append((j!=3)?".":"");
            //}
            //ans.add(sb.toString());
            //sb.delete(0,sb.length());
            //return;
            ans.add(String.join(".",temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isValid(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(s,ans,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isValid(String s){
        if(s.length()>3 || (s.length()>1 && s.charAt(0)=='0')){
            return false;
        }
        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}

//TC: O(1)
//SC: O(k) number of valid IP's