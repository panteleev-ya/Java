package ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        int x = 10;
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }

    Stack<Integer> storage = new Stack<>();
    Stack<Integer> buffer = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        storage.push(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }
        while (!empty()) {
            buffer.push(storage.pop());
        }
        int popped = buffer.pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return popped;
    }

    public int peek() {
        if (!empty()) {
            while (!empty()) {
                buffer.push(storage.pop());
            }
            int peeked = buffer.peek();
            while (!buffer.isEmpty()) {
                push(buffer.pop());
            }
            return peeked;
        }
        return 0;
    }

    public boolean empty() {
        return storage.isEmpty();
    }
}
