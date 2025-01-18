class Solution {
    public boolean isPalindrome(String s) {
        //Initilize one pointer at start of the input string and one at the end
        int left = 0, right = s.length() - 1;

        //Iterate until both the pointers meet
        while(left < right){
            //Iterate until a valid character is found at the left pointer
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            //Iterate until a valid character is found at the right pointer
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            //Check if both the charcters at both pointers are same
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                //If not, return flse indicating the string isn't palindrome
                return false;
            }

            left++;
            right--;
        }

        //return true if all the characters satify palindrome rules
        return true;
    }
}

//Time Complexity: O(N)
//Space Complexity: O(1)