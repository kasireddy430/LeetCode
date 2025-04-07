class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if(Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                    continue;
                } else if(Math.abs(asteroid) == stack.peek()){
                    stack.pop();
                }
                asteroid = 0;
            }

            if(asteroid != 0){
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = stack.get(i);
        }

        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)