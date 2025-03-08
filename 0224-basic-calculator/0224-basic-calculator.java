class Solution {
    public int calculate(String s) {
        //Initialize a stack to store results and signs for handling paranthesis
        Stack<Integer> stack = new Stack<>();
        int sign = 1;//tracking signs(1 for '+' and -1 for '-')
        int result = 0;//stores onGoing computed value
        int operand = 0;//tracking current number(for handling numbers with mmulti-digit)

        //Iterate through each character in input string
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);

            //Case 1: If character is digit add it to the operand
            if(Character.isDigit(c)){
                operand = (operand * 10) + (c - '0');
            } //Case 2: If character is '+' add ongoing operand to result and reset operand
            else if(c == '+'){
                result += sign * operand;
                sign = 1;
                operand = 0;
            }//Case 3: If character is '-' then add ongoing operand to result, update sign
            //and reset operand
            else if(c == '-'){
                result += sign * operand;
                sign = -1;
                operand = 0;
            }//Case 4: If character is '(' add result and sign to stack
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }//Case 5: If character is ')' calculate expression within paranthesis
            else if(c == ')'){
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
                sign = 1;
            }
        }

        //Add final operand to the result and return(handles when last character is operand)
        return result + (sign * operand);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)