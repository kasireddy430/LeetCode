class Solution {
    public boolean isHappy(int n) {
        //Initialize pointers at n
        int slow = n, fast = n;

        //Continue until both slow and fast pointers meet
        do{
            slow = findSquareSum(slow); //Move slow pointer by one step
            fast = findSquareSum(findSquareSum(fast)); //Move fast pointer by 2 steps
        } while(slow != fast);

        //If slow reaches 1, then input is happy number
        return slow == 1;
    }

    private int findSquareSum(int num){
        //Initialize a varible to calculte sum of squared digits
        int sum = 0;
        //Iterate until num reaches 0
        while(num > 0){
            //Get the last digit of the number
            int digit = num % 10;
            sum += digit * digit; //Add the squared digit to sum
            num /= 10; //Remove last digit of the number
        }
        return sum;
    }
}

//Time Complexity: O(log n)
//Space Complexity: O(1)