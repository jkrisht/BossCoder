package stacks.impl;

public class StackImplementation implements StackInterface {
    private int[] stack;
    private int size = -1;

    public StackImplementation(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Stack cannot be initiated with given capacity: " + capacity);
        }

        this.stack = new int[capacity];
    }

    @Override
    public boolean push(int value) {
        if (isEmpty() || !isFull()) {
            this.stack[++size] = value;
            return true;
        }

        throw new RuntimeException("Stack overflow");
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return this.stack[size--];
    }

    @Override
    public int size() {
        return this.size + 1;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return this.stack[size];
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    @Override
    public boolean isFull() {
        return size == this.stack.length - 1;
    }
}
