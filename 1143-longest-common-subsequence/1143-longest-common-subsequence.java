class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //Ensure text2 is smaller for optimized space usage
        if(text2.length() > text1.length()){
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }

        //Initialize an array to store LCA values
        int[] current = new int[text2.length() + 1];

        //Traverse text1 right -> left
        for(int i = text1.length() - 1; i >= 0; i--){
            int prev = 0; //stores current[j] before modification

            //Traverse text2 right -> left
            for(int j = text2.length() - 1; j >= 0; j--){
                int tmp = current[j];//store current[j] before modification

                //if character is same in both strings, update LCA value using it's previous value
                if(text1.charAt(i) == text2.charAt(j)){
                    current[j] = prev + 1;
                } else{//Update current LCA value if adjacent index value is greater
                    current[j] = Math.max(current[j], current[j + 1]);
                }
                prev = tmp;
            }
        }
        
        //return total LCA
        return current[0];
    }
}

//Time Complexity: O(mn)
//Space Complexity: O(min(m, n))