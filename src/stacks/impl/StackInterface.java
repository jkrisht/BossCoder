package stacks.impl;

public interface StackInterface {
    boolean push(int value);

    int pop();

    int size();

    int top();

    boolean isEmpty();

    boolean isFull();
}
