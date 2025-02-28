class Solution {
    public boolean checkValidString(String s) {
        //Initialize leftmin and leftmax variables for tracking minimum and maximum left parenthesis
        int leftMin = 0, leftMax = 0;

        //Iterate over each character in input string
        for(char c : s.toCharArray()){
            if(c == '('){//Check if it's open parenthesis
                leftMin++;
                leftMax++;
            } else if(c == ')'){//Check if it's closed parenthesis
                leftMin--;
                leftMax--;
            } else{//If it's a star it can be either '(' or ')'
                leftMin--;//Star as '('
                leftMax++;//star as ')'
            }

            if(leftMax < 0){ //Indicates number of closed parenthesis is greater than open paranthesis
                return false;
            }

            //Number of open paranthesis cannot be negative, reset the min variable to 0
            if(leftMin < 0){
                leftMin = 0; 
            }

        }

        //If leftMin equals 0, it implies string is valid meaning all parenthesis are valid
        return leftMin == 0;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)