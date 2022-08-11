package org.confluent;

import java.util.Stack;

public class MinStackImpl {
    private final Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int value) {
        if (min > value) {
            stack.push(min);
            min = value;
        }
        stack.push(value);
    }

    public int pop() {
        if (stack.empty()) {
            throw new RuntimeException("stack is empty");
        }

        int value = stack.pop();
        if (value == min) {
            min = stack.pop();
        }
        return value;
    }

    public int getMin() {
        return min;
    }

    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        MinStackImpl minStack = new MinStackImpl();
        minStack.push(5);

        System.out.println(minStack.getMin());
        minStack.push(3);
        minStack.push(1);

        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
    }
}
