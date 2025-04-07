class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (Math.abs(a) > stack.peek()) {
                    stack.pop();
                    continue;
                } else if (Math.abs(a) == stack.peek()) {
                    stack.pop();
                }
                a = 0;  // Both explode
            }
            if (a != 0) {
                stack.push(a);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i); // use get() to keep stack intact
        }
        return res;

    }
}