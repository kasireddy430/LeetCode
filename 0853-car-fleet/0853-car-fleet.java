class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        for(int[] pair : pairs){
            double timeToReach = (double)(target - pair[0]) / pair[1];
            stack.push(timeToReach);

            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}

//TC: O(n)
//SC: O(n)