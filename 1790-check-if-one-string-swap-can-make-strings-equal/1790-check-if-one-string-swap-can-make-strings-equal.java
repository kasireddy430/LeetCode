class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        //If both string are identical, no swap required for strings to be equal
        if(s1.equals(s2)){
            return true;
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
                    return false;//morethan two mismatches found, can't become equal with 1-swap
                }
            }
        }

        //If only one mismatch found in indices, then swaping doesn't work
        if(secondIndex == -1){
            return false;
        }

        //Check if swap is possible
        return s1.charAt(firstIndex) == s2.charAt(secondIndex) &&
            s1.charAt(secondIndex) == s2.charAt(firstIndex); 
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
