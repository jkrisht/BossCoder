package stacks;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')' && !stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, stack.empty() ? i + 1 : i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return result;
    }
}
