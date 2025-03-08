class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        //If both string are identical, check for duplicates
        if(s1.equals(s2)){
            return true;//if no duplicates found, then they aren't buddy strings
        }

        //If both strings differ, check if it has two indices different
        int firstIndex = -1, secondIndex = -1;//storing mismatched indices

        for(int i = 0; i < s1.length(); i++){
            //if characters at current index differ, then store indices
            if(s1.charAt(i) != s2.charAt(i)){
                if(firstIndex == -1){
                    firstIndex = i;
                } else if (secondIndex == -1){
                    secondIndex = i;
                } else{
                    return false;//morethan two mismatches found, can't be buddy strings
                }
            }
        }

        //If only one mismatch found in indices, then they can't be buddy strings
        if(secondIndex == -1){
            return false;
        }

        //Check if swapping indices fixes mismatch
        return s1.charAt(firstIndex) == s2.charAt(secondIndex) &&
            s1.charAt(secondIndex) == s2.charAt(firstIndex); 
    }
}