package stacks.getmin;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    int minElement;

    public MinStack() {
        this.stack = new Stack<>();
        this.minElement = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= minElement) {
            stack.push(minElement);
            minElement = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == minElement) {
            minElement = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minElement;
    }
}
