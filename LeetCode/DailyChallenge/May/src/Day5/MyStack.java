package Day5;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue<Integer> data;
    Queue<Integer> buffer;
    public MyStack() {
        data = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public int pop() {
        int last = moveDataToBufferReturnLast();
        moveDataFromBuffer(true);
        return last;
    }

    public int top() {
        int last = moveDataToBufferReturnLast();
        moveDataFromBuffer(false);
        return last;
    }

    private int moveDataToBufferReturnLast() {
        int last = -1;
        while (!data.isEmpty()) {
            last = data.poll();
            buffer.add(last);
        }
        return last;
    }

    private void moveDataFromBuffer(boolean removeLast) {
        if (buffer.isEmpty()) {
            return;
        }
        int last = buffer.poll();
        while (!buffer.isEmpty()) {
            data.add(last);
            last = buffer.poll();
        }
        if (!removeLast) {
            data.add(last);
        }
    }

    public boolean empty() {
        return data.isEmpty();
    }
}