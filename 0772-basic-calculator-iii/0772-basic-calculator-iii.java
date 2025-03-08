class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();//Stores intermediate results
        String currentNumber = "";//Stores current number(handling multi-digit numbers)
        char previousOperator = '+';//Stores operator to be evaluated
        s += "@";
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));//set of operators

        //Iterate through input string
        for(char c : s.toCharArray()){
            //if character is a digit add it to the current number
            if(Character.isDigit(c)){
                currentNumber += c;
            }//if character is open paranthesis, add previous operator to stack and reset previous operator
            else if(c == '('){
                stack.push(""+previousOperator);
                previousOperator = '+';
            }
            //if character is an operator or closed paranthesis
            else{
                //If previous operation is * or /, then evaluate operation 
                //by between last inserted number in stack and current number
                //and push it to stack
                if(previousOperator == '*' || previousOperator == '/'){
                    stack.push(evaluate(previousOperator, stack.pop(), currentNumber));
                } else {//Similary handle for +, -
                    stack.push(evaluate(previousOperator, currentNumber, "0"));
                }

                currentNumber = "";
                previousOperator = c;

                //If character is closed paranthesis, then add all elements in stack until 
                //an operator is found(implies performing operations within paranthesis)
                if(c == ')'){
                    int currentNum = 0;

                    while(!set.contains(stack.peek())){
                        currentNum += Integer.parseInt(stack.pop());
                    }

                    currentNumber = Integer.toString(currentNum);
                    previousOperator = stack.pop().charAt(0);
                }
            }
        }

        int ans = 0;
        //Iterate through stack and update final answer
        for(String st : stack){
            ans += Integer.parseInt(st);
        }

        return ans;
    }

    private String evaluate(char previousOperator, String first, String second){
        //Convert characters to integer type
        int x = Integer.parseInt(first);
        int y = Integer.parseInt(second);
        int res = 0;//Stores final result

        //evaluate operations to operands based on operator
        if(previousOperator == '+'){
            res = x;
        } else if(previousOperator == '-'){
            res = -x;
        } else if(previousOperator == '*'){
            res = x * y;
        } else if(previousOperator == '/'){
            res = x/y;
        }

        return Integer.toString(res);//convert int type to string type before returning
    }    
}

//Time COmplexity: O(n)
//Space COmplexity: O(n)