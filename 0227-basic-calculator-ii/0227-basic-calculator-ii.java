class Solution {
    public int calculate(String s) {
        //Edge Case: Return 0 if the input string is null or empty
        if(s == null || s.isEmpty()){
            return 0;
        }

        int length = s.length() - 1;
        int currentNumber = 0; //stores current number being processed(for handling multi-digit)
        int lastNumber = 0;//stores last number processed
        int result = 0;//stores final computed result
        char operator = '+';//stores last operator encountered(starting with +)

        //Iterate over each character in input array
        for(int i = 0; i <= length; i++){
            char c = s.charAt(i);
            //Check if character is digit
            if(Character.isDigit(c)){
                currentNumber = (currentNumber * 10) + (c - '0');
            } 
            
            //Check if character is operator or the end of the string
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == length){
                //if previous operator is + or - then add previously processed number to result
                //and update lastNumber based on the previous operator
                if(operator == '+' || operator == '-'){
                    result += lastNumber;
                    lastNumber = (operator == '+') ? currentNumber : -currentNumber;
                } else if(operator == '*'){
                    //if previous operator is '*' then process last and 
                    //current numbers by multiplication
                    lastNumber *= currentNumber;
                } else if(operator == '/'){
                    //if previous operator is '*' then process last and 
                    //current numbers by division
                    lastNumber /= currentNumber;
                }
                operator = c;
                currentNumber = 0;
            }
        }

        //return final result by adding last computed number
        return result + lastNumber;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)