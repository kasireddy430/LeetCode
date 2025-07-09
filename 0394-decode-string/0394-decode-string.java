class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // It's a number
                currentNum = currentNum * 10 + (c - '0'); // Handles multiple digit numbers
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                // Reset everything for the new calculation inside nested [
                currentString = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                // A loop has been closed. Pop and calculate strings to attach
                int repeatTimes = countStack.pop();
                StringBuilder stringToAttach = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    stringToAttach.append(currentString);
                }

                currentString = stringToAttach; // Re-assigns newly formed string for next iterations.
            } else {
                // It's an alphabet
                currentString.append(c);
            }
        }

        return currentString.toString(); // Return the resultant final string.
    }
}

// TC and SC: O(N)