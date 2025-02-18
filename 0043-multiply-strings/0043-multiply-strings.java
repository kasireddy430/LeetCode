public class Solution {
    public String multiply(String num1, String num2) {
        //Base case: If any of the two numbers are 0 then their 
        //nultiplication leads to 0
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        //Reverse both the input strings for simplifying multiplication process
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        //Initialize res array of length num1.length + num2.length
        int[] res = new int[num1.length() + num2.length()];

        //Iterate over both the strings and simulate multiplication process
        for(int i = 0; i < num1.length();i++){
            for(int j = 0; j < num2.length();j++){
                //Calculate the multiplication of digits and store in tmp
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //Add the tmp to currect position in res array
                res[i + j] += tmp;

                //if value at current position is greater than 9, carry over 
                //it to next index position
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] %= 10; //Store unit's place in current index
            }
        }

        StringBuilder result = new StringBuilder();

        //Skip leading 0's
        int i = res.length - 1;
        while(i >= 0 && res[i] == 0){
            i--;
        }

        //Append the digits to result
        while(i >= 0){
            result.append(res[i--]);
        }

        //Convert the result back to string before returning it
        return result.toString();
    }
}

//Time Complexity: O(m * n)
//Space Complexity: O(m + n)