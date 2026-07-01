import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove all temperatures that are not warmer
            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If stack is not empty, top is the next warmer day
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }

            // Push current index
            stack.push(i);
        }

        return ans;
    }
}