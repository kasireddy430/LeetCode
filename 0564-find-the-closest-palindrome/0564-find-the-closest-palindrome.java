class Solution {
    public String nearestPalindromic(String numberStr) {
        long number = Long.parseLong(numberStr);
        if(number <= 10) return String.valueOf(number - 1);
        if(number == 11) return "9";

        int length = numberStr.length();
        long leftHalf = Long.parseLong(numberStr.substring(0, (length + 1)/2));

        long[] palindromeCandidate = new long[5];

        palindromeCandidate[0] = generatepalindrome(leftHalf, length % 2 == 0);
        palindromeCandidate[1] = generatepalindrome(leftHalf - 1, length % 2 == 0);
        palindromeCandidate[2] = generatepalindrome(leftHalf + 1, length % 2 == 0);
        palindromeCandidate[3] = (long)Math.pow(10, length) + 1;
        palindromeCandidate[4] = (long)Math.pow(10, length - 1) - 1;

        long result = 0;
        long minDifference = Long.MAX_VALUE;
        for(long candidate : palindromeCandidate){
            if(candidate == number) continue;
            long difference = Math.abs(number - candidate);
            if(difference < minDifference || (difference == minDifference && candidate < result)){
                result = candidate;
                minDifference = difference;
            }
        }

        return String.valueOf(result);
    }

    private long generatepalindrome(long leftHalf, boolean isEven){
        long palindrome = leftHalf;
        if(!isEven) leftHalf /= 10;
        while(leftHalf != 0){
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }

        return palindrome;
    }
}

//TC: O(n) parsing through input string
//SC: O(1)

//https://leetcode.com/problems/find-the-closest-palindrome/submissions/1364740180/